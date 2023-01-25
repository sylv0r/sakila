package com.codingf;
import com.codingf.db.Db_connection;
import com.codingf.update.Update;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Update.update();
    }
}
