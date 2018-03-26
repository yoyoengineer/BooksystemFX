package com.yo.booksystem.dao;

import com.yo.booksystem.model.Bookin;
import com.yo.booksystem.model.BookinKey;

import java.util.List;

public interface BookinMapper {
    int deleteByPrimaryKey(BookinKey key);

    int insert(Bookin record);

    int insertSelective(Bookin record);

    Bookin selectByPrimaryKey(BookinKey key);

    List<Bookin> selectAll();
    int updateByPrimaryKeySelective(Bookin record);

    int updateByPrimaryKey(Bookin record);
}