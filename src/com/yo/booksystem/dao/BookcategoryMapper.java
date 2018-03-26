package com.yo.booksystem.dao;

import com.yo.booksystem.model.Bookcategory;

import java.util.List;

public interface BookcategoryMapper {
    int deleteByPrimaryKey(Integer categoryid);

    int insert(Bookcategory record);

    int insertSelective(Bookcategory record);

    Bookcategory selectByPrimaryKey(Integer categoryid);

    List<Bookcategory> selectByCategoryName(String categoryName);
    List<Bookcategory> selectAll();
    int updateByPrimaryKeySelective(Bookcategory record);

    int updateByPrimaryKey(Bookcategory record);
}