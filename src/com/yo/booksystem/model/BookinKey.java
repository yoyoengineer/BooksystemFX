package com.yo.booksystem.model;

import java.util.Date;

public class BookinKey {
    private String bookname;

    private Date indate;

    public BookinKey(String bookname, Date indate) {
        this.bookname = bookname;
        this.indate = indate;
    }

    public BookinKey() {
        super();
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }
}