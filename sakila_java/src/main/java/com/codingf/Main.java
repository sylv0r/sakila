package com.codingf;

import com.codingf.db.Select;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Select select = new Select("db");
        select.executeQuery("SELECT * FROM city");
    }
}
