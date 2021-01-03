package com.company;

import com.company.mongodb.MongoDbProfiler;
import com.company.mysql.MySqlProfiler;
import com.company.postgres.PostgresProfiler;


public class Main {
    public static void main(String[] args) throws Exception {


        System.out.println("MYSQL:");
        MySqlProfiler mysql = new MySqlProfiler();
        mysql.query("test", "Select * from testtable;");
        System.out.println("POSTGRES:");
        PostgresProfiler postgres = new PostgresProfiler();
        postgres.connect();
        System.out.println("MONGODB:");
        MongoDbProfiler mongodb = new MongoDbProfiler();
        mongodb.connect();

    }
}
