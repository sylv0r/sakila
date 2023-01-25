package com.codingf.db;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public abstract class Connection {
    private java.sql.Connection connection;

    public Connection(String properties) throws SQLException {
        ResourceBundle db = ResourceBundle.getBundle(properties);
        try {
            String driver = db.getString("db.driver");
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String host = db.getString("db.host");
        String port = db.getString("db.port");
        String dbname = db.getString("db.dbase");

        String URL = "jdbc:mysql://"+host+":"+port+"/"+dbname;

        String username = db.getString("db.user");
        String password =db.getString("db.pass");

        java.sql.Connection connection = DriverManager.getConnection(URL, username, password);

        if (connection == null) {
            System.err.println("Error");
        }
        this.connection = connection;
    }

    public abstract ResultSet executeQuery(String query) throws SQLException;


    public abstract int executeUpdate(String query) throws SQLException;


    public java.sql.Connection getConnection() {
        return connection;
    }
}
