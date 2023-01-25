package com.codingf.read;
import java.util.Scanner;

import com.codingf.db.Query;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Read {
    public static void read(String select, String from) throws SQLException {

        Query selectQuery = new Query("db");
        ResultSet rs = selectQuery.executeQuery("SELECT "+select+" FROM "+from+" ");


        while (rs.next()) {
            String coutry = rs.getString(from);
            System.out.println(coutry);
        }
    }
}
