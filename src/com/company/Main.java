package com.company;

import com.company.mongodb.MongoDbProfiler;
import com.company.mysql.MySqlProfiler;
import com.company.postgres.PostgresProfiler;
import com.mongodb.Mongo;

public class Main {
    public static void main(String[] args) throws Exception {

        MySqlProfiler mysql = new MySqlProfiler();

        mysql.connect();

        PostgresProfiler postgres = new PostgresProfiler();

        postgres.connect();

        MongoDbProfiler mongodb = new MongoDbProfiler();
        mongodb.connect();

    }
}
