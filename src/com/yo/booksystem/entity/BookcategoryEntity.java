package com.yo.booksystem.entity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Yoy on 2017/5/25.
 */
public class BookcategoryEntity {
    private IntegerProperty categoryid;

    private StringProperty categoryname;

    private StringProperty description;

    public BookcategoryEntity() {
    }

    public BookcategoryEntity(Integer categoryid, String categoryname, String description) {
        this.categoryid = new SimpleIntegerProperty(categoryid);
        this.categoryname = new SimpleStringProperty(categoryname);
        this.description = new SimpleStringProperty(description);
    }

    public int getCategoryid() {
        return categoryid.get();
    }

    public IntegerProperty categoryidProperty() {
        return categoryid;
    }

    public String getCategoryname() {
        return categoryname.get();
    }

    public StringProperty categorynameProperty() {
        return categoryname;
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid.set(categoryid);
    }

    public void setCategoryname(String categoryname) {
        this.categoryname.set(categoryname);
    }

    public void setDescription(String description) {
        this.description.set(description);
    }
}
