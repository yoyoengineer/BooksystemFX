package com.yo.booksystem.service;

import com.yo.booksystem.entity.BookinEntity;
import com.yo.booksystem.model.Bookin;
import javafx.collections.ObservableList;

import java.util.List;

/**
 * Created by Yoy on 2017/5/26.
 */
public interface BookinService {
    void inBook(String bookName, Integer bookNum);
    List<Bookin> selectAllBookin();
    ObservableList<BookinEntity> getBookinsTableData(List<Bookin> bookinsParameter);
}
