package com.company.db.cassandra;


import com.company.Profiler;
import com.company.model.CqlsQueryCreator;
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
        String query = new CqlsQueryCreator().cqlsInsert(dataSet, tableName);
        //query = "INSERT INTO people_info (";
        //System.out.println(query);
        connection.query(query);
        connection.close();
    }

    @Override
    public void select() {
        connection.query("SELECT * FROM people.people_info where name ='Sienna'");


    }

    @Override
    public void delete() {
        connection.query("TRUNCATE people");
    }





}
