package com.yo.booksystem.service;


import com.yo.booksystem.entity.PublisherEntity;
import com.yo.booksystem.model.Publisher;
import javafx.collections.ObservableList;

import java.util.List;

/**
 * Created by Yoy on 2017/5/26.
 */
public interface PublisherService {
    void savePublisher(String pubname, String pubconnector, String phonenum, String description);
    int getInsertNum();
    List<Publisher> selectAllPublishers();
    ObservableList<PublisherEntity> getPublisherTableData(List<Publisher> publishersParameter);
    ObservableList<PublisherEntity> searchPublishers(String keyWords);
}
