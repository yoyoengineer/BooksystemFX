package com.yo.booksystem.dao;

import com.yo.booksystem.model.Bookselling;
import com.yo.booksystem.model.BooksellingKey;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksellingMapper {
    int deleteByPrimaryKey(BooksellingKey key);

    int insert(Bookselling record);

    int insertSelective(Bookselling record);

    Bookselling selectByPrimaryKey(BooksellingKey key);

    List<Bookselling> selectAll();
    int updateByPrimaryKeySelective(Bookselling record);

    int updateByPrimaryKey(Bookselling record);
}