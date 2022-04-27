package com.example.demo.utility;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionManager {
    private static String url;
    private static String username;
    private static String password;
    private static Connection conn;

    private DatabaseConnectionManager(){}

    public static Connection getConnection(){
        if(conn != null){
            return conn;
        }
//        try{
//            InputStream propertiesStream = new FileInputStream("src/main/resources/application.properties");
//            Properties props = new Properties();
//            props.load(propertiesStream);
//
//            url = props.getProperty("db.url");
//            username = props.getProperty("db.username");
//            password = props.getProperty("db.password");
//            conn = DriverManager.getConnection(url, username, password);
//        }
//
//        catch(SQLException | IOException e){
//            e.printStackTrace();
//        }

        url = "jdbc:mysql://localhost:3306/employees_departments";
        username = "root";

        //Mac
        //password = "Keadb2022";
        //Windows
        password = "root";

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
