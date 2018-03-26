package com.yo.booksystem.service.serviceImpl;

import com.yo.booksystem.dao.BookcategoryMapper;
import com.yo.booksystem.entity.BookcategoryEntity;
import com.yo.booksystem.model.Bookcategory;
import com.yo.booksystem.service.CategoryService;
import com.yo.booksystem.utils.GetSqlSession;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by Yoy on 2017/5/24.
 */
public class CategoryServiceImpl implements CategoryService{

    private Bookcategory bookcategory = new Bookcategory();
    private int insertNum = 0;
    private SqlSession session;
    @Override
    public void saveCategory(String categoryName, String categoryDescription) {
        bookcategory.setCategoryname(categoryName);
        bookcategory.setDescription(categoryDescription);
        session = GetSqlSession.sessionRetuen();
        try{
            insertNum=session.insert("com.yo.booksystem.dao.BookcategoryMapper.insertSelective",bookcategory);
        }finally {
            session.commit();
            session.close();
        }
    }

    public int getInsertNum() {
        return insertNum;
    }

    public List<Bookcategory> selectAllCategory(){
        List<Bookcategory> bookcategories = null;
        session = GetSqlSession.sessionRetuen();
        try{
            bookcategories=session.selectList("com.yo.booksystem.dao.BookcategoryMapper.selectAll");
        }finally {
            session.commit();
            session.close();
        }
        return bookcategories;
    }

    public ObservableList<BookcategoryEntity> getBookcategoryTableData(List<Bookcategory> bookcategoriesParameter){
        ObservableList<BookcategoryEntity> bookcategoryEntities = FXCollections.observableArrayList();
        if (bookcategoriesParameter!=null) {
            for (Bookcategory bookcategory : bookcategoriesParameter) {
                bookcategoryEntities.add(new BookcategoryEntity(bookcategory.getCategoryid(), bookcategory.getCategoryname(), bookcategory.getDescription()));
            }
        }
        return bookcategoryEntities;
    }

    @Override
    public ObservableList<BookcategoryEntity> searchCategories(String keyWords) {
        List<Bookcategory> bookcategories = null;
        session =  GetSqlSession.sessionRetuen();
        if (!keyWords.isEmpty()){
            keyWords = "%"+keyWords+"%";
            bookcategories = session.selectList("com.yo.booksystem.dao.BookcategoryMapper.selectByCategoryName",keyWords);
        }
        return this.getBookcategoryTableData(bookcategories);
    }

}
