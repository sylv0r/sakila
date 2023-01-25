package com.codingf.delete;

import com.codingf.Main;
import java.sql.SQLException;
import java.lang.String;
import javax.management.Query;

public class Delete {
    public static void delete(String table_name, String fields, String values) throws SQLException {
        String string = new String();
        Query selectQuery = new Query("db");
        try {
            int result = selectQuery.executeUpdate(" DELETE " + table_name + " (" + fields + ") VALUES (" + values + ");");
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
