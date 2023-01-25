package com.codingf.create;

import com.codingf.db.Query;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Create {
    public static void create(String table_name, String fields, String values) throws SQLException {
        Query selectQuery = new Query("db");
        try {
            int result = selectQuery.executeUpdate("INSERT INTO `" + table_name + "` (" + fields + ") VALUES (" + values + ");");
            System.out.println("Nombre de lignes affectées : " + result);

            ResultSet rs = selectQuery.executeQuery("SELECT * FROM city");
            while (rs.next()) {
                String city = rs.getString("city");
                System.out.println(city);
            }
        } catch (SQLException e) {
            System.out.println("Une information est incorrecte, veuillez-réessayer");
        }
    }
}
