package com.yo.booksystem.service;

import com.yo.booksystem.entity.BookcategoryEntity;
import com.yo.booksystem.model.Bookcategory;
import javafx.collections.ObservableList;

import java.util.List;

/**
 * Created by Yoy on 2017/5/24.
 */
public interface CategoryService {
    void saveCategory(String categoryName,String categoryDescription);
    List<Bookcategory> selectAllCategory();
    ObservableList<BookcategoryEntity> getBookcategoryTableData(List<Bookcategory> bookcategories);
    ObservableList<BookcategoryEntity> searchCategories(String keyWords);
}
