package com.yo.booksystem.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by Yoy on 2017/5/24.
 */
public class GetSqlSession {
    public static SqlSession sessionRetuen(){
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("sqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(reader);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();
        return session;
    }
}
