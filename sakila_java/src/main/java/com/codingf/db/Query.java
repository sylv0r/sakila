package com.codingf.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query extends Connection {
    java.sql.Connection connection;

    public Query(String properties) throws SQLException {
        super(properties);
    }

    @Override
    public ResultSet executeQuery(String query) throws SQLException {
        this.connection = getConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        return rs;
    }
    @Override
    public int executeUpdate(String query) throws SQLException{
        Statement stmt = getConnection().createStatement();
        return stmt.executeUpdate(query);
    }
}
