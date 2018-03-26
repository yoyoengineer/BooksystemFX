package com.yo.booksystem.model;

public class Book {
    private Integer bookid=0;

    private String bookname="";

    private Float price= Float.valueOf(0);

    private Integer remain=0;

    private String author="";

    private String publisher="";

    private String img="";

    private String description="";

    private String bookcategory="";

    public Book(Integer bookid, String bookname, Float price, Integer remain, String author, String publisher, String img, String description, String bookcategory) {
        this.bookid = bookid;
        this.bookname = bookname;
        this.price = price;
        this.remain = remain;
        this.author = author;
        this.publisher = publisher;
        this.img = img;
        this.description = description;
        this.bookcategory = bookcategory;
    }

    public Book() {
        super();
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getRemain() {
        return remain;
    }

    public void setRemain(Integer remain) {
        this.remain = remain;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getBookcategory() {
        return bookcategory;
    }

    public void setBookcategory(String bookcategory) {
        this.bookcategory = bookcategory == null ? null : bookcategory.trim();
    }
}