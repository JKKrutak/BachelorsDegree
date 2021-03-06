package com.company;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper
{
    private static String url;
    private static ConnectionHelper instance;
    private ConnectionHelper() {}

    public static Connection getConnection(String connectionUrl, String username, String password) throws SQLException {
        url = connectionUrl;
        if (instance == null) { //singleton
            instance = new ConnectionHelper();
        }
        try {
            return DriverManager.getConnection(instance.url, username,password);
        } catch (SQLException e) {
            throw e;
        }
    }
    public static void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}