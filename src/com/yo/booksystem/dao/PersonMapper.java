package com.yo.booksystem.dao;

import com.yo.booksystem.model.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonMapper {
    int deleteByPrimaryKey(String account);

    int insert(Person record);

    int insertSelective(Person record);

    Person selectByPrimaryKey(String account);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);
}