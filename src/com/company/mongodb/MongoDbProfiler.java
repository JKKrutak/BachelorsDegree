package com.company.mongodb;

import com.company.ConnectionHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MongoDbProfiler {
    private Connection connection = null;

    public MongoDbProfiler(String url, String username, String password){
        try {
            Class.forName(url);
            //connection = ConnectionHelper.getConnection("jdbc:mysql://localhost:50", username, password);
            connection = ConnectionHelper.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
/*
    public void connect(String url, String database, String username, String password) throws Exception {
        try
        {
            Class.forName(url);
            connection = ConnectionHelper.getConnection(url, username, password);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }*/
    public void query(String database, String query) throws Exception {
        try {
            Statement stm = connection.createStatement();
            stm.executeQuery("use "+database);
            ResultSet rs = stm.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {

    }
}

