package com.codingf.update;

import com.codingf.db.Query;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Update {

    public static void update(String set, String where ) throws SQLException {
        Query selectQuery = new Query("db");
        int result =  selectQuery.executeUpdate("UPDATE `country` SET `country`='" + set + "' WHERE country = '"+where+"';");
        System.out.println("Nombre de lignes affectées : " + result);

        ResultSet rs = selectQuery.executeQuery("SELECT * FROM country");
        while (rs.next()) {
            String city = rs.getString("country");
            System.out.println(city);
        }
    }




}
