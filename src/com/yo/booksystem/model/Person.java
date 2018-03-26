package com.yo.booksystem.model;

public class Person {
    private String account;

    private String password;

    public Person(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public Person() {
        super();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}