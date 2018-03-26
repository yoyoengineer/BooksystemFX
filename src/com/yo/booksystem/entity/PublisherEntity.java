package com.yo.booksystem.entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Yoy on 2017/5/25.
 */
public class PublisherEntity {
    private StringProperty pubname;

    private StringProperty pubconnector;

    private StringProperty phonenum;

    private StringProperty description;

    public PublisherEntity() {
    }

    public PublisherEntity(String pubname, String pubconnector, String phonenum, String description) {
        this.pubname = new SimpleStringProperty(pubname);
        this.pubconnector = new SimpleStringProperty(pubconnector);
        this.phonenum = new SimpleStringProperty(phonenum);
        this.description = new SimpleStringProperty(description);
    }

    public String getPubname() {
        return pubname.get();
    }

    public StringProperty pubnameProperty() {
        return pubname;
    }

    public void setPubname(String pubname) {
        this.pubname.set(pubname);
    }

    public String getPubconnector() {
        return pubconnector.get();
    }

    public StringProperty pubconnectorProperty() {
        return pubconnector;
    }

    public void setPubconnector(String pubconnector) {
        this.pubconnector.set(pubconnector);
    }

    public String getPhonenum() {
        return phonenum.get();
    }

    public StringProperty phonenumProperty() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum.set(phonenum);
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }
}
