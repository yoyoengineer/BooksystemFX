package com.yo.booksystem.service.serviceImpl;

import com.yo.booksystem.entity.BookEntity;
import com.yo.booksystem.model.Book;
import com.yo.booksystem.service.BookManagingService;
import com.yo.booksystem.utils.GetSqlSession;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yoy on 2017/5/26.
 */
public class BookManagingServiceImpl implements BookManagingService{

    Book book = new Book();
    private SqlSession session;
    private int insertNum = 0;

    @Override
    public ObservableList<BookEntity> searchPublishers(String keyWords) {
        List<Book> books = null;
        session =  GetSqlSession.sessionRetuen();
        if (!keyWords.isEmpty()){
            keyWords = "%"+keyWords+"%";
            books = session.selectList("com.yo.booksystem.dao.BookMapper.selectByBookname",keyWords);
        }
        return this.getBooksTableData(books);
    }

    public void saveBook(String bookname, String price, String author, String bookcategory, String publisher, String img, String description) {

        book.setBookname(bookname);
        book.setPrice(Float.parseFloat(price));
        book.setAuthor(author);
        book.setBookcategory(bookcategory);
        book.setPublisher(publisher);
        book.setImg(img);
        book.setDescription(description);
        session = GetSqlSession.sessionRetuen();

        try{
            insertNum=session.insert("com.yo.booksystem.dao.BookMapper.insertSelective",book);
        }finally {
            session.commit();
            session.close();
        }
    }

    public ObservableList<BookEntity> getBooksTableData(List<Book> booksParameter){
        ObservableList<BookEntity> publisherEntities = FXCollections.observableArrayList();
        if (booksParameter!=null){
            for (Book book:booksParameter) {
                publisherEntities.add(new BookEntity(book.getBookid(),book.getBookname(),book.getPrice(),book.getRemain(),book.getAuthor(),book.getPublisher(),book.getImg(),book.getDescription(),book.getBookcategory()));
            }
        }
        return publisherEntities;
    }

    public List<Book> selectAllBooks(){
        List<Book> books = null;
        session = GetSqlSession.sessionRetuen();
        try{
            books=session.selectList("com.yo.booksystem.dao.BookMapper.selectAll");
        }finally {
            session.commit();
            session.close();
        }
        return books;
    }

    @Override
    public Book getBookByName(String bookName) {
        session = GetSqlSession.sessionRetuen();
        try{
            book=session.selectOne("com.yo.booksystem.dao.BookMapper.selectByBookname", bookName);
        }finally {
            session.commit();
            session.close();
        }
        return book;
    }

    @Override
    public void updateBookRemain(String bookName, int bookNum) {
        session = GetSqlSession.sessionRetuen();
        Book book;
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("bookid",bookNum);
//        map.put("bookname",bookName);
        try{
            book = session.selectOne("com.yo.booksystem.dao.BookMapper.selectByBookname", bookName);
            book.setRemain(bookNum);
            session.update("com.yo.booksystem.dao.BookMapper.updateByPrimaryKeySelective", book);
        }finally {
            session.commit();
            session.close();
        }
    }

    @Override
    public Book getBookByPrimaryKey(int id) {
        session = GetSqlSession.sessionRetuen();
        Book book = null;
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("bookid",bookNum);
//        map.put("bookname",bookName);
        try{
            book = session.selectOne("com.yo.booksystem.dao.BookMapper.selectByPrimaryKey", id);
        }finally {
            session.commit();
            session.close();
        }
        return book;
    }
}
