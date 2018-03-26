package com.yo.booksystem.entity;

import javafx.beans.property.StringProperty;

/**
 * Created by Yoy on 2017/5/25.
 */
public class PersonEntity {
    private StringProperty account;

    private StringProperty password;

    public PersonEntity() {
    }

    public PersonEntity(StringProperty account, StringProperty password) {
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account.get();
    }

    public StringProperty accountProperty() {
        return account;
    }

    public void setAccount(String account) {
        this.account.set(account);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }
}
