package com.codingf.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectQuery extends Connection {
    java.sql.Connection connection;

    public SelectQuery(String properties) throws SQLException {
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
