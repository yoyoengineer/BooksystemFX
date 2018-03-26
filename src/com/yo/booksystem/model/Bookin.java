package com.yo.booksystem.model;

import java.util.Date;

public class Bookin extends BookinKey {
    private Integer innum;

    public Bookin(String bookname, Date indate, Integer innum) {
        super(bookname, indate);
        this.innum = innum;
    }

    public Bookin() {
        super();
    }

    public Integer getInnum() {
        return innum;
    }

    public void setInnum(Integer innum) {
        this.innum = innum;
    }

    @Override
    public String toString() {
        return "Bookin{" +
                "innum=" + innum +"," +
                "bookname=" + super.getBookname()+
                '}' ;
    }
}