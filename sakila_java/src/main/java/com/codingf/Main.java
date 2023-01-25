package com.codingf;

import com.codingf.create.Create;
import com.codingf.db.Query;
import com.codingf.update.Update;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Query selectQuery = new Query("db");
        ResultSet rs = selectQuery.executeQuery("SELECT table_name FROM information_schema.tables WHERE table_schema = 'sakila';");

        while (rs.next()) {
            System.out.println(rs.getString("table_name"));
        }
        //Create.create("city", "city, country_id", "'test2_city', '2'");
    }
}
