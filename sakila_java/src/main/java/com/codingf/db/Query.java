package com.codingf.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
