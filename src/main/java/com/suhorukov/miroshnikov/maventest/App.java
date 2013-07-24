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
        GuestBookControllerH2DB controller = null;
        try {
            controller = new GuestBookControllerH2DB();
            controller.createTableGuestBook();
            work(controller);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            controller.close();
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
