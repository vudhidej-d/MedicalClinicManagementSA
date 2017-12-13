package controllers;

import java.sql.*;

public class DBController {

    private Connection connect() {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:Db.db";
            connection = DriverManager.getConnection(dbURL);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void loadPatientRecords() {
        Connection connection = connect();
        try {
            if (connection != null) {
                String query = "Select * from Patient";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
