package com.company.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySqlProfiler {
    private Connection connection = null;

    public MySqlProfiler(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = ConnectionHelper.getConnection("jdbc:mysql://localhost:50");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
        } finally {
            connection.close();
        }


    }


}

