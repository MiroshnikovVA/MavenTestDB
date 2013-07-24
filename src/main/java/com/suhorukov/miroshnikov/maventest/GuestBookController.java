package com.suhorukov.miroshnikov.maventest;

import java.sql.SQLException;
import java.util.List;

/**
 * Гостевая книга
 */
public interface GuestBookController {
    void addRecord(String message) throws SQLException;
    List<Record> getRecords() throws SQLException;
}
