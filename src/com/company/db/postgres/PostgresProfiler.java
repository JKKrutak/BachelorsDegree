package com.company.db.postgres;

import com.company.ConnectionHelper;
import com.company.Profiler;
import com.company.model.DataSet;
import com.company.model.MySqlQueryCreator;

import java.sql.Connection;
import java.sql.Statement;

public class PostgresProfiler implements Profiler {
    private Connection connection = null;
    public PostgresProfiler(String url, String username, String password) throws Exception {
            Class.forName("org.postgresql.Driver");
            connection =  ConnectionHelper.getConnection(url,username, password);
    }

    @Override
    public void insert(DataSet dataSet, String tableName) {
        MySqlQueryCreator query = new MySqlQueryCreator();
        try {
            Statement stm = connection.createStatement();
            //System.out.println(query);
            stm.execute(query.mySqlInsert(dataSet,tableName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void select() {
        try {
            Statement stm = connection.createStatement();
            //System.out.println(query);
            stm.execute("SELECT * FROM people_info WHERE name = 'Sienna'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {
        try {
            Statement stm = connection.createStatement();
            //System.out.println(query);
            stm.executeUpdate("TRUNCATE TABLE people_info");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void closeConnection() throws Exception{
        connection.close();
    }

}

