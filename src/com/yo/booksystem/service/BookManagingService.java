package com.yo.booksystem.service;

import com.yo.booksystem.entity.BookEntity;
import com.yo.booksystem.model.Book;
import javafx.collections.ObservableList;

import java.util.List;

/**
 * Created by Yoy on 2017/5/26.
 */
public interface BookManagingService {
    ObservableList<BookEntity> searchPublishers(String keyWords);
    void saveBook(String bookname, String price, String author, String bookcategory,String publisher,String img,String description);
    ObservableList<BookEntity> getBooksTableData(List<Book> booksParameter);
    List<Book> selectAllBooks();
    Book getBookByName(String bookName);
    void updateBookRemain(String bookName ,int bookNum);
    Book getBookByPrimaryKey(int id);
}
