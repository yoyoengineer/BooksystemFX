package com.yo.booksystem.entity;

import javafx.beans.property.*;
import jdk.nashorn.internal.parser.DateParser;

import java.util.Date;

/**
 * Created by Yoy on 2017/5/26.
 */
public class BookinEntity {
    private IntegerProperty innum;
    private StringProperty bookname;
    private StringProperty indate;
    private FloatProperty price;

    public BookinEntity() {
    }

    public BookinEntity(Integer innum, String bookname, Date indate, float price) {
        this.innum = new SimpleIntegerProperty(innum);
        this.bookname = new SimpleStringProperty(bookname);
        this.indate = new SimpleStringProperty(indate.toString());
        this.price = new SimpleFloatProperty(price);
    }

    public int getInnum() {
        return innum.get();
    }

    public IntegerProperty innumProperty() {
        return innum;
    }

    public void setInnum(int innum) {
        this.innum.set(innum);
    }

    public String getBookname() {
        return bookname.get();
    }

    public StringProperty booknameProperty() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname.set(bookname);
    }

    public String getIndate() {
        return indate.get();
    }

    public StringProperty indateProperty() {
        return indate;
    }

    public void setIndate(String indate) {
        this.indate.set(indate);
    }

    public float getPrice() {
        return price.get();
    }

    public FloatProperty priceProperty() {
        return price;
    }

    public void setPrice(float price) {
        this.price.set(price);
    }

    @Override
    public String toString() {
        return "BookinEntity{" +
                "innum=" + innum +
                ", bookname=" + bookname +
                ", indate=" + indate +
                ", price=" + price +
                '}';
    }
}
