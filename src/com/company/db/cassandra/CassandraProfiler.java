package com.company.db.cassandra;


import com.company.Profiler;
import com.company.model.DataSet;
import com.company.model.MySqlQueryCreator;

public class CassandraProfiler implements Profiler {
    private CassandraConnector connection;
    public CassandraProfiler(String node, Integer port) {
        connection = new CassandraConnector();
        connection.connect(node, port);
    }

    @Override
    public void insert(DataSet dataSet, String tableName) {
        String query;
        //query = "INSERT INTO people_info (";

        connection.query(new MySqlQueryCreator().mySqlInsert(dataSet,tableName) );
        connection.close();
    }





}
