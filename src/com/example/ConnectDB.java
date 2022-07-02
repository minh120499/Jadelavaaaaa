package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// import java.sql.ResultSet;
// import java.sql.Statement;

public class ConnectDB {
    private static String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static String USER_NAME = "root";
    private static String PASSWORD = "";
    private static ConnectDB connectDB;
    private static Connection conn = null;

    private ConnectDB() {
    }

    public static ConnectDB getConnect() {
        if(connectDB == null) {
            return new ConnectDB();
        }
        return connectDB;
    }

    public static void close() throws SQLException {
        conn.close();
    }

    public static Connection getConnection() {
        conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager. getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }

    // public ResultSet resultQuery(String query) {
    //     try {
    //         Connection conn = getConnection();
    //         Statement stmt = conn.createStatement();
    //         ResultSet rs = stmt.executeQuery(query);
    //         conn.close();

    //         return rs;
    //     } catch (Exception ex) {
    //         ex.printStackTrace();
    //     }

    //     return null;
    // }
}