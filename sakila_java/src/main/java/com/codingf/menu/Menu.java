package com.codingf.menu;

import com.codingf.create.Create;
import com.codingf.db.Query;
import com.codingf.read.Read;
import com.codingf.update.Update;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Menu {
    public static void menu() throws SQLException {
        Query selectQuery = new Query("db");
        int i = 1;
        int choice;

        Map<String, String> tableMap = new HashMap<String, String>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Menu:");

        ResultSet rs = selectQuery.executeQuery("SELECT table_name FROM information_schema.tables WHERE table_schema = 'sakila';");
        while (rs.next()) {
            String table = rs.getString("table_name");
            tableMap.put(Integer.toString(i), table);
            System.out.println(i + "/" + " " + table);
            i += 1;
        }

        System.out.print("Votre choix : ");

        String choiceTable = scanner.next();

        System.out.println(tableMap.get(choiceTable));
        i = 1;

        System.out.println("Que voulez-vous faire avec la table "+tableMap.get(choiceTable));
        System.out.println("1. Afficher");
        System.out.println("2. Créer un nouveau tuple");
        System.out.println("3. Modifier un tuple");
        System.out.println("4. Surimer un tuple ");
        choice = scanner.nextInt();
        String champ;
        switch (choice){
            case 1:
                System.out.println("table : "+tableMap.get(choiceTable));
                Read.read("*", tableMap.get(choiceTable));
                break;
            case 2:

                System.out.println("Veuillez remplir ces champs :");
                String all_fields = getFields(tableMap.get(choiceTable));
                champ = afficher_champ_no_null(tableMap.get(choiceTable));
                Create.create(tableMap.get(choiceTable),all_fields,champ);

                break;
            case 3:
                System.out.println("Veuillez choisir un champ");
                champ = afficher_champ(tableMap.get(choiceTable));
                System.out.println("Veuillez choisir la valeur");
                String valeur = scanner.next();
                System.out.println("Veuillez choisir la condition sous la forme : champsigne'valeur' (exemple: country='france' ");
                String where = scanner.next();

                Update.update(tableMap.get(choiceTable),champ, valeur, where);

                break;
            case 4:
                System.out.println("Vous avez choisi l'option 4.");

                break;
            case 5:
                System.out.println("Vous avez choisi l'option 4.");
                System.exit(0);
                break;
            default:
                System.out.println("Veuillez choisir un bon choix.");
        }
    }

    public static String getFields(String table) throws SQLException {
        Query selectQuery = new Query("db");
        String return_string = "";

        ResultSet rs = selectQuery.executeQuery("SHOW COLUMNS FROM "+table+";");
        while (rs.next()) {
            String champ = rs.getString("Field");
            if (Objects.equals(rs.getString("Extra"), "")) {
                return_string+=rs.getString("Field")+",";
            }
        }
        return return_string.substring(0, return_string.length()-1);
    }

    public static String afficher_champ(String table) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Query selectQuery = new Query("db");
        int i = 1;
        Map<String, String> tableMap = new HashMap<String, String>();

        ResultSet rs = selectQuery.executeQuery("SHOW COLUMNS FROM "+table+";");
        while (rs.next()) {
            String champ = rs.getString("Field");
            if (!Objects.equals(rs.getString("Key"), "PRI") && !Objects.equals(rs.getString("Key"), "MUL")) {
                tableMap.put(Integer.toString(i), champ);
                System.out.println(i + "/" + " " + champ);
                i += 1;
            }
        }
        String choiceChamp = scanner.next();


        return tableMap.get(choiceChamp);
    }

    public static String afficher_champ_no_null(String table) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Query selectQuery = new Query("db");
        int i = 1;
        Map<String, String> tableMap = new HashMap<String, String>();

        ResultSet rs = selectQuery.executeQuery("SHOW COLUMNS FROM "+table+";");
        while (rs.next()) {
            String champ = rs.getString("Field");
            if (Objects.equals(rs.getString("Extra"), "")) {
                tableMap.put(Integer.toString(i), champ);
                System.out.println(champ);
                i += 1;
            }
        }
        System.out.println("Au format 'valeur1','valeur2' (sans espace) dans l'ordre d'apparition");
        String choiceChamp = scanner.next();
        return choiceChamp;
    }
}