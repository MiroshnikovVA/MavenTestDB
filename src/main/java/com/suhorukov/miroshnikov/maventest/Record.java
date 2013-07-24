package com.suhorukov.miroshnikov.maventest;

import java.util.Date;

/**
 * Запись в блоге
 * */
public class Record {
    private int id;
    private Date postDate;
    private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
