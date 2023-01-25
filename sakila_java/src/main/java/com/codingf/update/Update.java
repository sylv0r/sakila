package com.codingf.update;

import com.codingf.db.Db_connection;

import java.sql.SQLException;

public class Update {
    public static void update() throws SQLException {
        Db_connection.db("country","country","Yemen");

    }
}
