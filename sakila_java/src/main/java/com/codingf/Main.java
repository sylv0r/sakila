package com.codingf;

import com.codingf.db.SelectQuery;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        SelectQuery selectQuery = new SelectQuery("db");
        ResultSet rs = selectQuery.executeQuery("SELECT * FROM country");
        while (rs.next()) {
            String city = rs.getString("country");
            System.out.println(city);
        }
    }
}
