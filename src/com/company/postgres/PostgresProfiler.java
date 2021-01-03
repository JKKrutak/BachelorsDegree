package com.company.postgres;

import com.company.ConnectionHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostgresProfiler {
    private Connection connection = null;
    public PostgresProfiler(String url, String username, String password) throws Exception {
            Class.forName("org.postgresql.Driver");
            connection =  ConnectionHelper.getConnection(url,username, password);
    }

    public void query(String database, String query) throws Exception {

            Statement stm = connection.createStatement();
            //stm.executeQuery("use "+database+";");
            ResultSet rs = stm.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
            }
        }

    public void closeConnection() throws Exception{
        connection.close();
    }

}

