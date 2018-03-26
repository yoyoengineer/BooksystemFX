package com.yo.booksystem.service.serviceImpl;

import com.yo.booksystem.dao.PersonMapper;
import com.yo.booksystem.model.Person;
import com.yo.booksystem.service.Check;
import com.yo.booksystem.utils.GetSqlSession;
import javafx.beans.property.StringProperty;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by Yoy on 2017/5/24.
 */

public class CheckImpl implements Check {

    private boolean checkbool = false;
    private Person person;
    @Override
    public boolean verify(String account, String password) {
//        Reader reader = null;
//        try {
//            reader = Resources.getResourceAsReader("sqlMapConfig.xml");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//        SqlSession session = sqlSessionFactory.openSession();
        SqlSession session = GetSqlSession.sessionRetuen();
        try{
            person = (Person) session.selectOne("com.yo.booksystem.dao.PersonMapper.selectByPrimaryKey",account);
        }finally {
            session.commit();
            session.close();
        }
        System.out.println(account);
        String psw = person.getPassword();
        if(password.equals(psw)){
            checkbool = true;
        }
        return checkbool;
    }
}
