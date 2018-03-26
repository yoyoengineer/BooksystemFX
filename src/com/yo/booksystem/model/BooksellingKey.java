package com.yo.booksystem.model;

import java.util.Date;

public class BooksellingKey {
    private Date tradedate;

    private Integer bookid;

    public BooksellingKey(Date tradedate, Integer bookid) {
        this.tradedate = tradedate;
        this.bookid = bookid;
    }

    public BooksellingKey() {
        super();
    }

    public Date getTradedate() {
        return tradedate;
    }

    public void setTradedate(Date tradedate) {
        this.tradedate = tradedate;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }
}