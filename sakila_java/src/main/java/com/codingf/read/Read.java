package com.codingf.read;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

import com.codingf.db.Query;

import java.sql.ResultSet;
import java.sql.SQLException;
public class Read {

    public static void read(String from) throws SQLException {

        Query selectQuery = new Query("db");
        ResultSet rs = selectQuery.executeQuery("SELECT * FROM "+from+";");

        // Récupération des métadonnées de la requête
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

    }
}
