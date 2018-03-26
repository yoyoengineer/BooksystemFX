package com.yo.booksystem.model;

import java.util.Date;

public class Bookselling extends BooksellingKey {
    private Float price;

    private Integer amount;

    public Bookselling(Date tradedate, Integer bookid, Float price, Integer amount) {
        super(tradedate, bookid);
        this.price = price;
        this.amount = amount;
    }

    public Bookselling() {
        super();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}