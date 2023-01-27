package com.codingf.delete;

import com.codingf.Main;
import com.codingf.db.Query;


import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Delete {
    public static void delete(String table_name, String condition) throws SQLException {
        String string = new String();
        Query selectQuery = new Query("db");

        try {
            String sql = "DELETE FROM " + table_name + " WHERE " + condition + ";";
            int result = selectQuery.executeUpdate(sql);
            System.out.println("Nombre de lignes affectées : " + result);


            ResultSet rs = selectQuery.executeQuery("SELECT * FROM "+table_name+";");
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

        } catch (SQLException e) {
            System.out.println("Une information est incorrecte, veuillez réessayer\n" +
                    "ou le champ que vous essayez de supprimer est relié à une autre table");
        }
    }

}
