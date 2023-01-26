package com.codingf.create;

import com.codingf.db.Query;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Create {
    public static void create(String table_name, String fields, String values) throws SQLException {
        Query selectQuery = new Query("db");
        try {
            String sql = "INSERT INTO `" + table_name + "` (" + fields + ") VALUES (" + values + ");";
            int result = selectQuery.executeUpdate(sql);
            System.out.println("Nombre de lignes affectées : " + result);

            // Récupération des données de la table
            ResultSet rs = selectQuery.executeQuery("SELECT * FROM " + table_name + ";");
            ResultSetMetaData metaData = rs.getMetaData();
            // Nombre de colonnes dans la table
            int columnCount = metaData.getColumnCount();

            // Affichage des noms de colonnes
            for (int column = 1; column <= columnCount; column++) {
                System.out.printf("%-20s", metaData.getColumnName(column));
            }
            System.out.println();
            System.out.println("------------------------------------------------------------------------------------------------------");

            // Affichage des données
            while (rs.next()) {
                for (int column = 1; column <= columnCount; column++) {
                    System.out.printf("%-20s", rs.getString(column));
                }
                System.out.println();
            }
            System.out.println("------------------------------------------------------------------------------------------------------");
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Une information est incorrecte, veuillez-réessayer");
        }
    }
}
