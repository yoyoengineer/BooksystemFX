package com.yo.booksystem.service.serviceImpl;

import com.yo.booksystem.dao.BookinMapper;
import com.yo.booksystem.entity.BookEntity;
import com.yo.booksystem.entity.BookinEntity;
import com.yo.booksystem.model.Bookin;
import com.yo.booksystem.service.BookManagingService;
import com.yo.booksystem.service.BookinService;
import com.yo.booksystem.utils.DateUtil;
import com.yo.booksystem.utils.GetSqlSession;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;

/**
 * Created by Yoy on 2017/5/26.
 */
public class BookinServiceImpl implements BookinService{
    private SqlSession session;
    private Bookin bookin = new Bookin();
    private BookManagingService bookManagingService = new BookManagingServiceImpl();
    @Override
    public void inBook(String bookName, Integer bookNum) {
        Date time= DateUtil.getTime();
//        bookin.setInnum(Integer.parseInt(bookNum));
        bookin.setInnum(bookNum);
        bookin.setBookname(bookName);
        bookin.setIndate(time);
        try{
            session = GetSqlSession.sessionRetuen();
            session.insert("com.yo.booksystem.dao.BookinMapper.insertSelective",bookin);
        }finally {
            session.commit();
            session.close();
        }
    }

    @Override
    public List<Bookin> selectAllBookin() {
        List<Bookin> bookins = null;
        session = GetSqlSession.sessionRetuen();
//        System.out.println("session.selectList(\"com.yo.booksystem.dao.PublisherMapper.selectAll\")"+session.selectList("com.yo.booksystem.dao.PublisherMapper.selectAll"));
//        System.out.println("session.selectList(\"com.yo.booksystem.dao.BookinMapper.selectAll\")"+session.selectList("com.yo.booksystem.dao.BookinMapper.selectAll"));
        try{
            bookins=session.selectList("com.yo.booksystem.dao.BookinMapper.selectAll");
        }finally {
            session.commit();
            session.close();
        }
        return bookins;
    }

    public ObservableList<BookinEntity> getBookinsTableData(List<Bookin> bookinsParameter){
        ObservableList<BookinEntity> BookinEntities = FXCollections.observableArrayList();
        if (bookinsParameter!=null){
            for (Bookin bookin:bookinsParameter) {

                BookinEntities.add(new BookinEntity(bookin.getInnum(),bookin.getBookname(),bookin.getIndate(),bookManagingService.getBookByName(bookin.getBookname()).getPrice()));
            }
        }
        return BookinEntities;
    }
}
