package com.suhorukov.miroshnikov.maventest;

import java.io.Closeable;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: MiroshnikovVA
 * Date: 20.07.13
 * Time: 11:21
 * To change this template use File | Settings | File Templates.
 */
public class GuestBookControllerH2DB extends H2DBConnectable implements GuestBookController {


    private Connection dbConnection = null;

    public void createTableGuestBook() throws SQLException, ClassNotFoundException {

        PreparedStatement preparedStatement = null;

        String createTableSQL = "CREATE TABLE GUEST_BOOK("
                + "ID NUMBER(5) NOT NULL AUTO_INCREMENT, "
                + "POST_DATE DATE NOT NULL, "
                + "MESSAGE VARCHAR(200) NOT NULL, "
                + "PRIMARY KEY (ID) "
                + ")";

        try {
            dbConnection = getCurrentConnection();
            preparedStatement = dbConnection.prepareStatement(createTableSQL);

            System.out.println(createTableSQL);

            // execute create SQL stetement
            preparedStatement.executeUpdate();

            System.out.println("Table \"GUEST_BOOK\" is created!");

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            //throw e;

        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

    }


    public GuestBookControllerH2DB() throws ClassNotFoundException, SQLException {
        super();
    }

    @Override
    public void addRecord(String message) throws SQLException {
        PreparedStatement preparedStatement = null;

        String insertTableSQL = "INSERT INTO GUEST_BOOK"
                + " (POST_DATE, MESSAGE) "
                + " VALUES (?, ?)";

        try {
            dbConnection = getCurrentConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            System.out.println(insertTableSQL);

            // execute create SQL stetement
            java.util.Date now = new java.util.Date();
            preparedStatement.setDate(1, new Date(now.getTime()));
            preparedStatement.setString(2, message);
            preparedStatement.executeUpdate();

            System.out.println("insert message in Table \"GUEST_BOOK\"!");

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            //throw e;

        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }


        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Record> getRecords() throws SQLException {
        PreparedStatement preparedStatement = null;

        String selectTableSQL = "SELECT ID, POST_DATE, MESSAGE FROM GUEST_BOOK";

        ArrayList<Record> records = new ArrayList<>();

        try {
            dbConnection = getCurrentConnection();
            preparedStatement = dbConnection.prepareStatement(selectTableSQL);

            System.out.println(selectTableSQL);

            // execute create SQL stetement
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                Record rec = new Record();
                rec.setId(rs.getInt("ID"));
                rec.setPostDate(rs.getDate("POST_DATE"));
                rec.setMessage(rs.getString("MESSAGE"));
                records.add(rec);
            }


            System.out.println("selected FROM Table \"GUEST_BOOK\"!");

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            //throw e;

        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }


        return records;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
