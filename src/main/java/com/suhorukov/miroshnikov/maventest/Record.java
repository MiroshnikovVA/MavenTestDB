package com.suhorukov.miroshnikov.maventest;

import java.util.Date;

/**
 * Запись в блоге
 * */
public class Record {
    private int id;
    private Date postDate;
    private String message;

    public Record(int id, Date postDate, String message) {
        this.id = id;
        this.postDate = postDate;
        this.message = message;
    }

    public Record() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Record record = (Record) o;

        if (id != record.id) return false;
        if (message != null ? !message.equals(record.message) : record.message != null) return false;
        if (postDate != null ? !postDate.equals(record.postDate) : record.postDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (postDate != null ? postDate.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", postDate=" + postDate +
                ", message='" + message + '\'' +
                '}';
    }

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
