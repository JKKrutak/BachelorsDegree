package com.company;

import com.company.db.cassandra.CassandraProfiler;
import com.company.db.couchdb.CouchDbProfiler;
import com.company.db.mongodb.MongoDbProfiler;
import com.company.db.mysql.MySqlProfiler;
import com.company.db.postgres.PostgresProfiler;
import com.company.model.CqlsQueryCreator;
import com.company.model.DataSet;
import com.company.model.MySqlQueryCreator;


public class Main {
    public static void main(String[] args) throws Exception {
        int dataSetSize = 120;
        DataSet dataSet = new DataSet(dataSetSize);

        long start;
        long end;
        long elapsedTime;

        MySqlQueryCreator newQuery = new MySqlQueryCreator();

/*

        System.out.println("MYSQL:");
        MySqlProfiler mysql = new MySqlProfiler("jdbc:mysql://localhost:3308","root","123"); //Połącznie
      //System.out.println(newQuery.mySqlInsert(1000,"people_info")); //Wypisanie całej query
        start = System.nanoTime();
        mysql.insert(dataSet,"people_info"); //100k jest za dużo jak coś xD ale do 50k jest okxD
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("MySQL czas wykonanie "+dataSetSize+" wpisów: "+elapsedTime+"ms");



        System.out.println("POSTGRES:");
        PostgresProfiler postgres = new PostgresProfiler("jdbc:postgresql://localhost:5432/people","postgres","123");
        start = System.nanoTime();
        postgres.insert(dataSet,"people_info"); //100k jest za dużo jak coś xD ale do 50k jest ok
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("Postgres czas na wykonanie "+dataSetSize+" wpisów: "+elapsedTime+"ms");
        postgres.closeConnection();


        System.out.println("MONGODB:");
        MongoDbProfiler mongodb = new MongoDbProfiler();  //"jdbc:mongodb://localhost:53/pionki","user","123");
        start = System.nanoTime();
        mongodb.insert(dataSet,"");
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("MongoDB czas na wykonanie "+dataSetSize+" wpisów: "+elapsedTime+"ms");


        CouchDbProfiler couchDb = new CouchDbProfiler("http://admin:123@localhost:5984" , "people");
        couchDb.insert(dataSet,"");

*/

        CassandraProfiler cassandra = new CassandraProfiler("localhost",9042);
        //CqlsQueryCreator kwerenda = new CqlsQueryCreator();
        //System.out.println(kwerenda.cqlsInsert(dataSet,"people_info"));
        //System.out.println();
        cassandra.insert(dataSet,"people_info");




    }
}
