package com.suhorukov.miroshnikov.maventest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        try (GuestBookControllerH2DB controller = new GuestBookControllerH2DB()) {
            controller.createTableGuestBook();
            work(controller);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    static void work(GuestBookController controller) throws SQLException {
        controller.addRecord("Привет!");
        controller.addRecord("Пока!");
        List<Record> list = controller.getRecords();
        for (Record rec : list) {
            System.out.println(rec.getId() + " "
                    + rec.getPostDate() + " \n"
                    + rec.getMessage() + "\n--------------");
        }
    }


}
