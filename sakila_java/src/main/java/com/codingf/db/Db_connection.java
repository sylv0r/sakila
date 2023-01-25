package com.codingf.db;
import java.sql.*;
import java.util.ResourceBundle;


public class Db_connection {



        public static void db(String select, String from, String value) throws SQLException {
            //System.out.println("Application Sakila");
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
            }catch (ClassNotFoundException e){
                System.out.println("Errorloadingdriver");
                System.exit(-1);
            }
            //System.out.println("Le driver est chargé!!!!!!!!");

            ResourceBundle bundle = ResourceBundle.getBundle("db");

            ///URL de connexion
            String host = bundle.getString("db.host");
            String dbName= bundle.getString("db.dbase");
            String dbport= bundle.getString("db.port");
            int port =3306;
            String URL ="jdbc:mysql://"+host +":"+port +"/"+dbName;

            String username="root";
            String password="";

            Connection connection = DriverManager.getConnection(URL,username,password);
            if (connection==null) {
                System.err.println("Erreur de connexion!!!");
            }else {
                System.out.println("connexion etablie");
            }


            Statement stmt = connection.createStatement();

            int test = stmt.executeUpdate("UPDATE `"+select+"` SET `country`='"+value+"' WHERE country = '[non]'; ");
            ResultSet pays= stmt.executeQuery("SELECT country FROM country");

            //UPDATE `users` SET `email`='[admin@gmail.coma]' WHERE email = "admin@gmail.com";
            ResultSetMetaData resultMeta = pays.getMetaData();

            while(pays.next()){
                for(int i = 1; i <= resultMeta.getColumnCount(); i++) {
                    System.out.println("pays: "+ pays.getObject(i).toString());
                }
            }

            /*ResultSet city= stmt.executeQuery("SELECT city FROM city");
            while(city.next()){
                for(int i = 1; i <= resultMeta.getColumnCount(); i++) {
                    System.out.println(" ville: "+ city.getObject(i).toString());
                }
            }*/
        }
    }

