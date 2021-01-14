package com.company;
import com.company.mongodb.MongoDbProfiler;
import com.company.mysql.MySqlProfiler;
import com.company.postgres.PostgresProfiler;
import com.company.couchdb.CouchDbProfiler;
import com.company.model.DataSet;
import com.company.model.MySqlQueryCreator;

import java.lang.*;


public class Main {
    public static void main(String[] args) throws Exception {
        int dataSetSize = 50;
        DataSet dataSet = new DataSet(dataSetSize);

        long start;
        long end;
        long elapsedTime;

        MySqlQueryCreator newQuery = new MySqlQueryCreator();



        System.out.println("MYSQL:");
        MySqlProfiler mysql = new MySqlProfiler("jdbc:mysql://localhost:50","root","123"); //Połącznie
      //System.out.println(newQuery.mySqlInsert(1000,"people_info")); //Wypisanie całej query
        start = System.nanoTime();
        mysql.insert(dataSet,"people_info"); //100k jest za dużo jak coś xD ale do 50k jest okxD
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("MySQL czas wykonanie "+dataSetSize+" wpisów: "+elapsedTime+"ms");


        System.out.println("POSTGRES:");
        PostgresProfiler postgres = new PostgresProfiler("jdbc:postgresql://localhost:52/people","postgres","123");
        start = System.nanoTime();
        postgres.insert(dataSet,"people_info"); //100k jest za dużo jak coś xD ale do 50k jest ok
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("Postgres czas na wykonanie "+dataSetSize+" wpisów: "+elapsedTime+"ms");
        postgres.closeConnection();


        System.out.println("MONGODB:");
        MongoDbProfiler mongodb = new MongoDbProfiler();  //"jdbc:mongodb://localhost:53/pionki","user","123");
        start = System.nanoTime();
        mongodb.insert(dataSet,"NiematozanczeniaxDDDDDDDDDD");
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("MongoDB czas na wykonanie "+dataSetSize+" wpisów: "+elapsedTime+"ms");

       // CouchDbProfiler couchDb = new CouchDbProfiler("http://admin:123@localhost:5984" , "pionki");


    }
}
