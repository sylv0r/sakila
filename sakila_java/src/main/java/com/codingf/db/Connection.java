package com.codingf.db;

import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public abstract class Connection {
    private java.sql.Connection connection;

    /**
     * Classe de service permettant d'obtenir un objet connexion
     * - La connexion s'effectue en lisant un fichier properties qui doit contenir tous les éléments
     * permettant la connexion : login, password, dbase, etc ...
     */

    private static Properties properties;
    private static Properties getFileProperties(String fileName) {

        Properties props = new Properties();
        FileReader input ;
        try {
            input = new FileReader(fileName);
            props.load(input);
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement des properties :" + e.getMessage());
        }
        // for debug

        return props;
    }

    public Connection(String properties) throws SQLException {

        Properties prop = getFileProperties("db.properties");

        //ResourceBundle db = ResourceBundle.getBundle(properties);

        try {
            String driver = prop.getProperty("db.driver");
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String host = prop.getProperty("db.host");
        String port = prop.getProperty("db.port");
        String dbname = prop.getProperty("db.dbase");

        String URL = "jdbc:mysql://"+host+":"+port+"/"+dbname;

        String username = prop.getProperty("db.user");
        String password =prop.getProperty("db.pass");

        java.sql.Connection connection = DriverManager.getConnection(URL, username, password);

        if (connection == null) {
            System.err.println("Error");
        }
        this.connection = connection;
    }

    public abstract ResultSet executeQuery(String query) throws SQLException;


    public abstract int executeUpdate(String query) throws SQLException;

    public java.sql.Connection getConnection() {
        return connection;
    }
}
