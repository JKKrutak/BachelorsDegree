package com.company;

import com.company.db.cassandra.CassandraProfiler;
import com.company.db.couchdb.CouchDbProfiler;
import com.company.db.derby.DerbyProfiler;
import com.company.db.mongodb.MongoDbProfiler;
import com.company.db.mysql.MySqlProfiler;
import com.company.db.postgres.PostgresProfiler;
import com.company.model.CqlsQueryCreator;
import com.company.model.DataSet;
import com.company.model.MySqlQueryCreator;


public class Main {
    public static void main(String[] args) throws Exception {
        int dataSetSizeV1 = 50000;
        int dataSetSizeV2 = 100000;
        int dataSetSizeV3 = 150000;
        int dataSetSizeV4 = 200000;
        int dataSetSizeV5 = 250000;

        DataSet DataSetV1 = new DataSet(dataSetSizeV1);
        DataSet DataSetV2 = new DataSet(dataSetSizeV2);
        DataSet DataSetV3 = new DataSet(dataSetSizeV3);
        DataSet DataSetV4 = new DataSet(dataSetSizeV4);
        DataSet DataSetV5 = new DataSet(dataSetSizeV5);

        long start;
        long end;
        long elapsedTime;
        //MySqlQueryCreator newQuery = new MySqlQueryCreator();
/*


        MySqlProfiler mysql = new MySqlProfiler("jdbc:mysql://localhost:3308","root","123"); //Connection
        System.out.println("MYSQL wielkość zbioru danych: "+dataSetSizeV1);
        start = System.nanoTime();
        mysql.insert(DataSetV1,"people_info");
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("MySQL czas wykonanie zapytania insert z "+dataSetSizeV1+" wpisami wynosi: "+elapsedTime+"ms\n");
        start = System.nanoTime();
        mysql.select();
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("MySQL czas wykonanie zapytania select wynosi: "+elapsedTime+"ms\n");
        start = System.nanoTime();
        mysql.delete();
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("MySQL czas wykonanie zapytania truncate wynosi: "+elapsedTime+"ms\n");

        System.out.println("MYSQL wielkość zbioru danych: "+dataSetSizeV2);
        start = System.nanoTime();
        mysql.insert(DataSetV2,"people_info");
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("MySQL czas wykonanie zapytania insert z "+dataSetSizeV2+" wpisami wynosi: "+elapsedTime+"ms\n");
        start = System.nanoTime();
        mysql.select();
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("MySQL czas wykonanie zapytania select wynosi: "+elapsedTime+"ms\n");
        start = System.nanoTime();
        mysql.delete();
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("MySQL czas wykonanie zapytania truncate wynosi: "+elapsedTime+"ms\n");

        System.out.println("MYSQL wielkość zbioru danych: "+dataSetSizeV3);
        start = System.nanoTime();
        mysql.insert(DataSetV3,"people_info");
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("MySQL czas wykonanie zapytania insert z "+dataSetSizeV3+" wpisami wynosi: "+elapsedTime+"ms\n");
        start = System.nanoTime();
        mysql.select();
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("MySQL czas wykonanie zapytania select wynosi: "+elapsedTime+"ms\n");
        start = System.nanoTime();
        mysql.delete();
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("MySQL czas wykonanie zapytania truncate wynosi: "+elapsedTime+"ms\n");

        System.out.println("MYSQL wielkość zbioru danych: "+dataSetSizeV4);
        start = System.nanoTime();
        mysql.insert(DataSetV4,"people_info");
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("MySQL czas wykonanie zapytania insert z "+dataSetSizeV4+" wpisami wynosi: "+elapsedTime+"ms\n");
        start = System.nanoTime();
        mysql.select();
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("MySQL czas wykonanie zapytania select wynosi: "+elapsedTime+"ms\n");
        start = System.nanoTime();
        mysql.delete();
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("MySQL czas wykonanie zapytania truncate wynosi: "+elapsedTime+"ms\n");

        System.out.println("MYSQL wielkość zbioru danych: "+dataSetSizeV5);
        start = System.nanoTime();
        mysql.insert(DataSetV5,"people_info");
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("MySQL czas wykonanie zapytania insert z "+dataSetSizeV5+" wpisami wynosi: "+elapsedTime+"ms\n");
        start = System.nanoTime();
        mysql.select();
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("MySQL czas wykonanie zapytania select wynosi: "+elapsedTime+"ms\n");
        start = System.nanoTime();
        mysql.delete();
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("MySQL czas wykonanie zapytania truncate wynosi: "+elapsedTime+"ms\n");
        mysql.closeConnection();

        PostgresProfiler postgres = new PostgresProfiler("jdbc:postgresql://localhost:5432/people","postgres","123"); //connection
        System.out.println("Postgres wielkość zbioru danych: "+dataSetSizeV1);
        start = System.nanoTime();
        postgres.insert(DataSetV1,"people_info");
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("Postgres czas na wykonanie zapytania insert z "+dataSetSizeV1+" wpisami wynosi: "+elapsedTime+"ms\n");
        start = System.nanoTime();
        postgres.select();
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("Postgres czas na wykonanie zapytania select wynosi: "+elapsedTime+"ms\n");
        start = System.nanoTime();
        postgres.delete();
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("Postgres czas na wykonanie zapytania TRUNCATE wynosi: "+elapsedTime+"ms\n");

        System.out.println("Postgres wielkość zbioru danych: "+dataSetSizeV2);
        start = System.nanoTime();
        postgres.insert(DataSetV2,"people_info");
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("Postgres czas na wykonanie zapytania insert z "+dataSetSizeV2+" wpisami wynosi: "+elapsedTime+"ms\n");
        start = System.nanoTime();
        postgres.select();
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("Postgres czas na wykonanie zapytania select wynosi: "+elapsedTime+"ms\n");
        start = System.nanoTime();
        postgres.delete();
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("Postgres czas na wykonanie zapytania TRUNCATE wynosi: "+elapsedTime+"ms\n");

        System.out.println("Postgres wielkość zbioru danych: "+dataSetSizeV3);
        start = System.nanoTime();
        postgres.insert(DataSetV3,"people_info");
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("Postgres czas na wykonanie zapytania insert z "+dataSetSizeV3+" wpisami wynosi: "+elapsedTime+"ms\n");
        start = System.nanoTime();
        postgres.select();
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("Postgres czas na wykonanie zapytania select wynosi: "+elapsedTime+"ms\n");
        start = System.nanoTime();
        postgres.delete();
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("Postgres czas na wykonanie zapytania TRUNCATE wynosi: "+elapsedTime+"ms\n");

        System.out.println("Postgres wielkość zbioru danych: "+dataSetSizeV4);
        start = System.nanoTime();
        postgres.insert(DataSetV4,"people_info");
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("Postgres czas na wykonanie zapytania insert z "+dataSetSizeV4+" wpisami wynosi: "+elapsedTime+"ms\n");
        start = System.nanoTime();
        postgres.select();
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("Postgres czas na wykonanie zapytania select wynosi: "+elapsedTime+"ms\n");
        start = System.nanoTime();
        postgres.delete();
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("Postgres czas na wykonanie zapytania TRUNCATE wynosi: "+elapsedTime+"ms\n");

        System.out.println("Postgres wielkość zbioru danych: "+dataSetSizeV5);
        start = System.nanoTime();
        postgres.insert(DataSetV5,"people_info");
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("Postgres czas na wykonanie zapytania insert z "+dataSetSizeV5+" wpisami wynosi: "+elapsedTime+"ms\n");
        start = System.nanoTime();
        postgres.select();
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("Postgres czas na wykonanie zapytania select wynosi: "+elapsedTime+"ms\n");
        start = System.nanoTime();
        postgres.delete();
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("Postgres czas na wykonanie zapytania TRUNCATE wynosi: "+elapsedTime+"ms\n");
        postgres.closeConnection();
*/
        DerbyProfiler derby = new DerbyProfiler();  //connection included


        System.out.println("Apache Derby wielkość zbioru danych: "+dataSetSizeV1);
        start = System.nanoTime();
        derby.insert(DataSetV1, "people_info");
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("Derby czas na wykonanie zapytania insert z "+dataSetSizeV1+" wpisami wynosi: "+elapsedTime+"ms\n");
        start = System.nanoTime();
        derby.select();
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("Derby czas na wykonanie zapytania select wynosi: "+elapsedTime+"ms\n");
        start = System.nanoTime();
        derby.delete();
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("Derby czas na wykonanie zapytania TRUNCATE wynosi: "+elapsedTime+"ms\n");

        System.out.println("Apache Derby wielkość zbioru danych: "+dataSetSizeV2);
        start = System.nanoTime();
        derby.insert(DataSetV2, "people_info");
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("Derby czas na wykonanie zapytania insert z "+dataSetSizeV2+" wpisami wynosi: "+elapsedTime+"ms\n");
        start = System.nanoTime();
        derby.select();
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("Derby czas na wykonanie zapytania select wynosi: "+elapsedTime+"ms\n");
        start = System.nanoTime();
        derby.delete();
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("Derby czas na wykonanie zapytania TRUNCATE wynosi: "+elapsedTime+"ms\n");

        System.out.println("Apache Derby wielkość zbioru danych: "+dataSetSizeV3);
        start = System.nanoTime();
        derby.insert(DataSetV3, "people_info");
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("Derby czas na wykonanie zapytania insert z "+dataSetSizeV3+" wpisami wynosi: "+elapsedTime+"ms\n");
        start = System.nanoTime();
        derby.select();
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("Derby czas na wykonanie zapytania select wynosi: "+elapsedTime+"ms\n");
        start = System.nanoTime();
        derby.delete();
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("Derby czas na wykonanie zapytania TRUNCATE wynosi: "+elapsedTime+"ms\n");

        System.out.println("Apache Derby wielkość zbioru danych: "+dataSetSizeV4);
        start = System.nanoTime();
        derby.insert(DataSetV4, "people_info");
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("Derby czas na wykonanie zapytania insert z "+dataSetSizeV4+" wpisami wynosi: "+elapsedTime+"ms\n");
        start = System.nanoTime();
        derby.select();
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("Derby czas na wykonanie zapytania select wynosi: "+elapsedTime+"ms\n");
        start = System.nanoTime();
        derby.delete();
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("Derby czas na wykonanie zapytania TRUNCATE wynosi: "+elapsedTime+"ms\n");

        System.out.println("Apache Derby wielkość zbioru danych: "+dataSetSizeV5);
        start = System.nanoTime();
        derby.insert(DataSetV5, "people_info");
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("Derby czas na wykonanie zapytania insert z "+dataSetSizeV5+" wpisami wynosi: "+elapsedTime+"ms\n");
        start = System.nanoTime();
        derby.select();
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("Derby czas na wykonanie zapytania select wynosi: "+elapsedTime+"ms\n");
        start = System.nanoTime();
        derby.delete();
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("Derby czas na wykonanie zapytania TRUNCATE wynosi: "+elapsedTime+"ms\n");





        //derby.select("people_info");



        /*

        System.out.println("MONGODB:");
        MongoDbProfiler mongodb = new MongoDbProfiler();  //"jdbc:mongodb://localhost:53/pionki","user","123");
        start = System.nanoTime();
        mongodb.insert(dataSet,"");
        end = System.nanoTime();
        elapsedTime = (end-start)/1000000;
        System.out.println("MongoDB czas na wykonanie "+dataSetSizeV1+" wpisów: "+elapsedTime+"ms");


        CouchDbProfiler couchDb = new CouchDbProfiler("http://admin:123@localhost:5984" , "people");
        couchDb.insert(dataSet,"");




        CassandraProfiler cassandra = new CassandraProfiler("localhost",9042);
        //CqlsQueryCreator kwerenda = new CqlsQueryCreator();
        //System.out.println(kwerenda.cqlsInsert(dataSet,"people_info"));
        //System.out.println();
        cassandra.insert(dataSet,"people_info");

        DerbyProfiler derby = new DerbyProfiler();
        derby.insert(dataSet, "people_info");
        derby.select("people_info");

*/
    }
}
