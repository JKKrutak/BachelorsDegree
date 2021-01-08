package com.company.mysql;

import com.company.ConnectionHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySqlProfiler {
    private Connection connection = null;

    public MySqlProfiler(String url, String username, String password){
        try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
            //connection = ConnectionHelper.getConnection("jdbc:mysql://localhost:50", username, password);
            connection = ConnectionHelper.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void query(String database, String query) throws Exception {
        try {
            Statement stm = connection.createStatement();

            stm.execute("use "+database);
            System.out.println(query);
            stm.execute(query);
            //ResultSet rs = stm.executeQuery(query);

           // while (rs.next()) {
              //  System.out.println(rs.getString(1));
             //   System.out.println(rs.getString(2));
          //  }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void closeConnection() throws Exception{
        connection.close();
    }


}

