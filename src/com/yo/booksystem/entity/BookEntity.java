package com.yo.booksystem.entity;

import javafx.beans.property.*;

/**
 * Created by Yoy on 2017/5/25.
 */
public class BookEntity {
    private IntegerProperty bookid;

    private StringProperty bookname;

    private FloatProperty price;

    private IntegerProperty remain;

    private StringProperty author;

    private StringProperty publisher;

    private StringProperty img;

    private StringProperty description;

    private StringProperty bookcategory;

    public BookEntity() {
    }

    public BookEntity(Integer bookid, String bookname, Float price, Integer remain, String author, String publisher, String img, String description, String bookcategory) {
        this.bookid = new SimpleIntegerProperty(bookid);
        this.bookname = new SimpleStringProperty(bookname);
        this.price = new SimpleFloatProperty(price);
        this.remain = new SimpleIntegerProperty(remain);
        this.author = new SimpleStringProperty(author);
        this.publisher = new SimpleStringProperty(publisher);
        this.img = new SimpleStringProperty(img);
        this.description = new SimpleStringProperty(description);
        this.bookcategory = new SimpleStringProperty(bookcategory);
    }

    public BookEntity(Integer bookid, String bookname, Float price, String author, String publisher, String img, String description, String bookcategory) {
        this.bookid = new SimpleIntegerProperty(bookid);
        this.bookname = new SimpleStringProperty(bookname);
        this.price = new SimpleFloatProperty(price);
        this.author = new SimpleStringProperty(author);
        this.publisher = new SimpleStringProperty(publisher);
        this.img = new SimpleStringProperty(img);
        this.description = new SimpleStringProperty(description);
        this.bookcategory = new SimpleStringProperty(bookcategory);
    }

    public int getBookid() {
        return bookid.get();
    }

    public IntegerProperty bookidProperty() {
        return bookid;
    }

    public String getBookname() {
        return bookname.get();
    }

    public StringProperty booknameProperty() {
        return bookname;
    }

    public float getPrice() {
        return price.get();
    }

    public FloatProperty priceProperty() {
        return price;
    }

    public int getRemain() {
        return remain.get();
    }

    public IntegerProperty remainProperty() {
        return remain;
    }

    public String getAuthor() {
        return author.get();
    }

    public StringProperty authorProperty() {
        return author;
    }

    public String getPublisher() {
        return publisher.get();
    }

    public StringProperty publisherProperty() {
        return publisher;
    }

    public String getImg() {
        return img.get();
    }

    public StringProperty imgProperty() {
        return img;
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setBookid(int bookid) {
        this.bookid.set(bookid);
    }

    public void setBookname(String bookname) {
        this.bookname.set(bookname);
    }

    public void setPrice(float price) {
        this.price.set(price);
    }

    public void setRemain(int remain) {
        this.remain.set(remain);
    }

    public void setAuthor(String author) {
        this.author.set(author);
    }

    public void setPublisher(String publisher) {
        this.publisher.set(publisher);
    }

    public void setImg(String img) {
        this.img.set(img);
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getBookcategory() {
        return bookcategory.get();
    }

    public StringProperty bookcategoryProperty() {
        return bookcategory;
    }

    public void setBookcategory(String bookcategory) {
        this.bookcategory.set(bookcategory);
    }
}
