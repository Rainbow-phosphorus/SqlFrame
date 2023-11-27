package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public static String url = "jdbc:mySql://192.168.1.36:3306/curort";
    public static String username = "curort";
    public static String password = "1234";
    //String url ="jdbc:mysql://localhost:3306/test";

    public static Connection getConnection()throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
