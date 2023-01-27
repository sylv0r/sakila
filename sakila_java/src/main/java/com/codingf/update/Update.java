package com.codingf.update;

import com.codingf.db.Query;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Update {

    public static void update(String update,String set,String value, String where ) throws SQLException {
        Query selectQuery = new Query("db");
        try {
            int result = selectQuery.executeUpdate("UPDATE `" + update + "` SET `" + set + "`='" + value + "' WHERE " + where + ";");

            System.out.println("Nombre de lignes affectées : " + result);
            ResultSet rs = selectQuery.executeQuery("SELECT * FROM "+update+";");

            while (rs.next()) {
                String city = rs.getString(set);
                System.out.println(city);
            }
        }catch(SQLException e){
            System.out.println("Vous avez rentrez une mauvaise information");
        }

    }




}
