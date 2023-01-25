package com.codingf.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select extends Connection {
    java.sql.Connection connection;

    public Select(String properties) throws SQLException {
        super(properties);
    }

    @Override
    public ResultSet executeQuery(String query) throws SQLException {
        this.connection = getConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String city = rs.getString("city");
            System.out.println(city);
        }
        return null;
    }
}
