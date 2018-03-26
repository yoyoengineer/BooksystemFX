package com.yo.booksystem.dao;

import com.yo.booksystem.model.Publisher;

import java.util.List;

public interface PublisherMapper {
    int deleteByPrimaryKey(String pubname);

    int insert(Publisher record);

    int insertSelective(Publisher record);

    Publisher selectByPrimaryKey(String pubname);

    List<Publisher> selectByPubname(String pubname);

    List<Publisher> selectAll();

    int updateByPrimaryKeySelective(Publisher record);

    int updateByPrimaryKey(Publisher record);
}