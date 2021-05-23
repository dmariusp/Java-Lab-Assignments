package com.example.demo.databaseconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DbConn {
    private static Connection conn = null;

    static {
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "PALab";
        String pass = "1234";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return conn;
    }
}