package com.yo.booksystem.service.serviceImpl;

import com.yo.booksystem.entity.BookcategoryEntity;
import com.yo.booksystem.entity.PublisherEntity;
import com.yo.booksystem.model.Bookcategory;
import com.yo.booksystem.model.Publisher;
import com.yo.booksystem.service.PublisherService;
import com.yo.booksystem.utils.GetSqlSession;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by Yoy on 2017/5/26.
 */
public class PublisherServiceImpl implements PublisherService{

    private Publisher publisher = new Publisher();
    private SqlSession session;
    private int insertNum = 0;
    @Override
    public void savePublisher(String pubname, String pubconnector, String phonenum, String description) {
        publisher.setPubname(pubname);
        publisher.setPubconnector(pubconnector);
        publisher.setPhonenum(phonenum);
        publisher.setDescription(description);

        session = GetSqlSession.sessionRetuen();

        try{
            insertNum=session.insert("com.yo.booksystem.dao.PublisherMapper.insertSelective",publisher);
        }finally {
            session.commit();
            session.close();
        }
    }

    public int getInsertNum() {
        return insertNum;
    }

    public List<Publisher> selectAllPublishers(){
        List<Publisher> publishers = null;
        session = GetSqlSession.sessionRetuen();
        try{
            publishers=session.selectList("com.yo.booksystem.dao.PublisherMapper.selectAll");
        }finally {
            session.commit();
            session.close();
        }
        return publishers;
    }

    public ObservableList<PublisherEntity> getPublisherTableData(List<Publisher> publishersParameter){
        ObservableList<PublisherEntity> publisherEntities = FXCollections.observableArrayList();
        if (publishersParameter!=null){
            for (Publisher publisher:publishersParameter) {
                publisherEntities.add(new PublisherEntity(publisher.getPubname(),publisher.getPubconnector(),publisher.getPhonenum(),publisher.getDescription()));
            }
        }
        return publisherEntities;
    }

    @Override
    public ObservableList<PublisherEntity> searchPublishers(String keyWords) {
        List<Publisher> publishers = null;
        session =  GetSqlSession.sessionRetuen();
        if (!keyWords.isEmpty()){
            keyWords = "%"+keyWords+"%";
            publishers = session.selectList("com.yo.booksystem.dao.PublisherMapper.selectByPubname",keyWords);
        }
        return this.getPublisherTableData(publishers);
    }
}
