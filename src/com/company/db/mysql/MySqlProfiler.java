package com.company.db.mysql;

import com.company.ConnectionHelper;
import com.company.Profiler;
import com.company.model.DataSet;
import com.company.model.MySqlQueryCreator;

import java.sql.Connection;
import java.sql.Statement;

public class MySqlProfiler implements Profiler {
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

    @Override
    public void insert(DataSet dataSet, String tableName) {
        try {
            MySqlQueryCreator query = new MySqlQueryCreator();
            Statement stm = connection.createStatement();
            stm.execute("use people");
            stm.execute(query.mySqlInsert(dataSet,tableName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void closeConnection() throws Exception{
        connection.close();
    }


}

