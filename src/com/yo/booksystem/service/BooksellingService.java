package com.yo.booksystem.service;

import com.yo.booksystem.entity.BooksellingEntity;
import com.yo.booksystem.model.Bookin;
import com.yo.booksystem.model.Bookselling;
import javafx.collections.ObservableList;

import java.util.List;

/**
 * Created by Yoy on 2017/6/2.
 */
public interface BooksellingService {
    void dealDone(String bookName, Integer bookNum);
    List<Bookselling> selectAllBooksellings();
    ObservableList<BooksellingEntity> getBooksellingTableData(List<Bookselling> booksellingsParameter);
}
