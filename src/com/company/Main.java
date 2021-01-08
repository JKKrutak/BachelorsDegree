package com.company;

import com.company.couchdb.CouchDbProfiler;
import com.company.mongodb.MongoDbProfiler;
import com.company.mysql.MySqlProfiler;
import com.company.postgres.PostgresProfiler;
import org.apache.commons.lang3.time.StopWatch;


public class Main {
    public static void main(String[] args) throws Exception {
/*
        String[] names = new String[1000];

        for(int i = 0; i < names.length; i++)
        {
            names[i] = "Jakub";
        }

        StopWatch mySqlBench = new StopWatch();


        System.out.println("MYSQL:");
        MySqlProfiler mysql = new MySqlProfiler("jdbc:mysql://localhost:50","root","123");
        mysql.query("test", "");
        mysql.query("test", "Select * from testtable;");
        mySqlBench.start();
        for(int i = 0; i < names.length; i++) {
            mysql.query("test", "Insert into testtable (firstname) values ('"+names[i]+"');");
        }
        //mysql.query("test", "Insert into testtable (firstname) values ('dzialajprosze');");
        mySqlBench.stop();
        mysql.closeConnection();
        System.out.println("Czas 1000 wpisow: "+mySqlBench.getTime());


        System.out.println("POSTGRES:");
        PostgresProfiler postgres = new PostgresProfiler("jdbc:postgresql://localhost:52/tttest","postgres","123");
        postgres.query("tttest","SELECT * FROM pionki");
        postgres.closeConnection();
*/
/*
        System.out.println("MONGODB:");
        //MongoDbProfiler mongodb = new MongoDbProfiler("mongodb://localhost:53/pionki", "user","123");
        MongoDbProfiler mongodb = new MongoDbProfiler("jdbc:mongodb://localhost:53/pionki", "user","123");
 */
        CouchDbProfiler couchDbProfiler = new CouchDbProfiler("http://admin:123@localhost:5984" , "pionki");



    }
}
