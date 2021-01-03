package com.company;

import com.company.mongodb.MongoDbProfiler;
import com.company.mysql.MySqlProfiler;
import com.company.postgres.PostgresProfiler;


public class Main {
    public static void main(String[] args) throws Exception {


        System.out.println("MYSQL:");
        MySqlProfiler mysql = new MySqlProfiler("root","123");
        mysql.query("test", "Select * from testtable;");
        mysql.closeConnection();

        System.out.println("POSTGRES:");
        PostgresProfiler postgres = new PostgresProfiler("jdbc:postgresql://localhost:52/tttest","postgres","123");
        postgres.query("tttest","SELECT * FROM pionki");
        postgres.closeConnection();


        System.out.println("MONGODB:");
        MongoDbProfiler mongodb = new MongoDbProfiler();
        mongodb.connect();

    }
}
