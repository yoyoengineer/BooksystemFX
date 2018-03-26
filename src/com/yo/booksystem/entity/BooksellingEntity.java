package com.yo.booksystem.entity;

import javafx.beans.property.*;

import java.util.Date;

/**
 * Created by Yoy on 2017/5/25.
 */
public class BooksellingEntity {
    private FloatProperty price;
    private IntegerProperty amount;
    private Date tradedate;
    private IntegerProperty bookid;
    private StringProperty bookName;

    public BooksellingEntity() {
    }

    public BooksellingEntity(Float price, Integer amount, Date tradedate, Integer bookid,String bookame) {
        this.price = new SimpleFloatProperty(price);
        this.amount = new SimpleIntegerProperty(amount);
        this.tradedate = tradedate;
        this.bookid = new SimpleIntegerProperty(bookid);
        this.bookName = new SimpleStringProperty(bookame);
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

    public int getAmount() {
        return amount.get();
    }

    public IntegerProperty amountProperty() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount.set(amount);
    }

    public Date getTradedate() {
        return tradedate;
    }

    public void setTradedate(Date tradedate) {
        this.tradedate = tradedate;
    }

    public int getBookid() {
        return bookid.get();
    }

    public IntegerProperty bookidProperty() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid.set(bookid);
    }

    public String getBookName() {
        return bookName.get();
    }

    public StringProperty bookNameProperty() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName.set(bookName);
    }
}
