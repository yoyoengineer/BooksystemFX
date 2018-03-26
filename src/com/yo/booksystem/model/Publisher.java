package com.yo.booksystem.model;

public class Publisher {
    private String pubname;

    private String pubconnector;

    private String phonenum;

    private String description;

    public Publisher(String pubname, String pubconnector, String phonenum, String description) {
        this.pubname = pubname;
        this.pubconnector = pubconnector;
        this.phonenum = phonenum;
        this.description = description;
    }

    public Publisher() {
        super();
    }

    public String getPubname() {
        return pubname;
    }

    public void setPubname(String pubname) {
        this.pubname = pubname == null ? null : pubname.trim();
    }

    public String getPubconnector() {
        return pubconnector;
    }

    public void setPubconnector(String pubconnector) {
        this.pubconnector = pubconnector == null ? null : pubconnector.trim();
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum == null ? null : phonenum.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}