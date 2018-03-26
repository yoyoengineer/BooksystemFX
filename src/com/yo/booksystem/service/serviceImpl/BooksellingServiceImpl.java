package com.yo.booksystem.service.serviceImpl;

import com.yo.booksystem.entity.BookinEntity;
import com.yo.booksystem.entity.BooksellingEntity;
import com.yo.booksystem.model.Book;
import com.yo.booksystem.model.Bookin;
import com.yo.booksystem.model.Bookselling;
import com.yo.booksystem.service.BookManagingService;
import com.yo.booksystem.service.BooksellingService;
import com.yo.booksystem.utils.DateUtil;
import com.yo.booksystem.utils.GetSqlSession;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;

/**
 * Created by Yoy on 2017/6/2.
 */
public class BooksellingServiceImpl implements BooksellingService {
    private SqlSession session;
    private Bookselling bookselling = new Bookselling();
    private BookManagingService bookManagingService = new BookManagingServiceImpl();
    private Book book;
    @Override
    public void dealDone(String bookName, Integer bookNum) {
        Date time= DateUtil.getTime();
        bookselling.setAmount(bookNum);
        book = bookManagingService.getBookByName(bookName);
        bookselling.setPrice(book.getPrice());
        bookselling.setBookid(book.getBookid());
        bookselling.setTradedate(time);
        try{
            session = GetSqlSession.sessionRetuen();
            session.insert("com.yo.booksystem.dao.BooksellingMapper.insertSelective",bookselling);
        }finally {
            session.commit();
            session.close();
        }
    }

    @Override
    public List<Bookselling> selectAllBooksellings() {
        List<Bookselling> booksellings = null;
        session = GetSqlSession.sessionRetuen();
        try{
            booksellings=session.selectList("com.yo.booksystem.dao.BooksellingMapper.selectAll");
        }finally {
            session.commit();
            session.close();
        }
        return booksellings;
    }

    public ObservableList<BooksellingEntity> getBooksellingTableData(List<Bookselling> booksellingsParameter){
        ObservableList<BooksellingEntity> BooksellingEntities = FXCollections.observableArrayList();
        if (booksellingsParameter!=null){
            for (Bookselling booksell:booksellingsParameter) {
                BooksellingEntities.add(new BooksellingEntity(booksell.getPrice(),booksell.getAmount(),booksell.getTradedate(),booksell.getBookid(),bookManagingService.getBookByPrimaryKey(booksell.getBookid()).getBookname()));
            }
        }
        return BooksellingEntities;
    }
}
