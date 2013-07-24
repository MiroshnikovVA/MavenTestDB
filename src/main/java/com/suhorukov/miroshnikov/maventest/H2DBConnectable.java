package com.suhorukov.miroshnikov.maventest;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: MiroshnikovVA
 * Date: 20.07.13
 * Time: 11:36
 * To change this template use File | Settings | File Templates.
 */
public abstract class H2DBConnectable implements Closeable {
    private static final String DB_DRIVER = "org.h2.Driver";
    //private static final String DB_CONNECTION = "jdbc:h2:mem:mydatabase";
    private static final String DB_CONNECTION = "jdbc:h2:~/marventestdb";

    private static final String DB_USER = "user1";
    private static final String DB_PASSWORD = "password1";

    protected Connection getNewConnection() throws ClassNotFoundException {

        Connection dbConnection = null;

        try {

            Class.forName(DB_DRIVER);

        } catch (ClassNotFoundException e) {

            System.out.println(e.getMessage());
            throw e;
        }

        try {

            dbConnection = DriverManager.getConnection(
                    DB_CONNECTION, DB_USER, DB_PASSWORD);
            return dbConnection;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return dbConnection;

    }

    private final Connection currentConnection;

    public H2DBConnectable() throws ClassNotFoundException {
        currentConnection = getNewConnection();
    }

    @Override
    public void close() {
        try {
            currentConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    protected Connection getCurrentConnection() {
        return currentConnection;
    }
}
