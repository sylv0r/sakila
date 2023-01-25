package com.codingf;

import com.codingf.create.Create;
import com.codingf.db.Query;
import com.codingf.update.Update;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        Create.create("city", "city, country_id", "'test2_city', '2'");
    }
}
