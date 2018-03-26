package com.yo.booksystem.dao;

import com.yo.booksystem.model.Book;

import java.util.List;
import java.util.Map;

public interface BookMapper {
    int deleteByPrimaryKey(Integer bookid);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer bookid);

    List<Book> selectAll();

    List<Book> selectByBookname(String bookName);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    void updateByBookName(Map<String,Object> map);

}