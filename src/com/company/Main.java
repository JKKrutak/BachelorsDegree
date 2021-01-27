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
    public static void mySQLTest(DataSet dataSet) {
        int dataSetSize = dataSet.getSize();
        long start;
        long end;
        long elapsedTimeSelect;
        long elapsedTimeInsert;
        long elapsedTimeDelete;

        MySqlProfiler mysql = new MySqlProfiler("jdbc:mysql://localhost:3308","root","123"); //Connection
        System.out.println("MYSQL wielkość zbioru danych: "+dataSetSize);
        start = System.nanoTime();
        mysql.insert(dataSet,"people_info");
        end = System.nanoTime();
        elapsedTimeInsert = (end-start)/1000000;

        start = System.nanoTime();
        mysql.select();
        end = System.nanoTime();
        elapsedTimeSelect = (end-start)/1000000;

        start = System.nanoTime();
        mysql.delete();
        end = System.nanoTime();
        elapsedTimeDelete = (end-start)/1000000;

        System.out.println("\tInsert\t|\tSelect\t|\tDelete\n");
        System.out.print("\t"+elapsedTimeInsert+"ms\t|\t"+elapsedTimeSelect+"ms\t|\t"+elapsedTimeDelete+"ms\n");

    }

    public static void postgresTest(DataSet dataSet) throws Exception {
        int dataSetSize = dataSet.getSize();
        long start;
        long end;
        long elapsedTimeSelect;
        long elapsedTimeInsert;
        long elapsedTimeDelete;

        PostgresProfiler postgres = new PostgresProfiler("jdbc:postgresql://localhost:5432/people","postgres","123"); //connection
        System.out.println("Postgres wielkość zbioru danych: "+dataSetSize);

        start = System.nanoTime();
        postgres.insert(dataSet,"people_info");
        end = System.nanoTime();
        elapsedTimeInsert = (end-start)/1000000;
        start = System.nanoTime();
        postgres.select();
        end = System.nanoTime();
        elapsedTimeSelect = (end-start)/1000000;
        start = System.nanoTime();
        postgres.delete();
        end = System.nanoTime();
        elapsedTimeDelete = (end-start)/1000000;

        System.out.println("\tInsert\t|\tSelect\t|\tDelete\n");
        System.out.print("\t"+elapsedTimeInsert+"ms\t|\t"+elapsedTimeSelect+"ms\t|\t"+elapsedTimeDelete+"ms\n");

    }

    public static void derbyTest(DataSet dataSet) throws Exception {
        int dataSetSize = dataSet.getSize();
        long start;
        long end;
        long elapsedTimeSelect;
        long elapsedTimeInsert;
        long elapsedTimeDelete;

        DerbyProfiler derby = new DerbyProfiler();
        //derby.select("people_info");


        System.out.println("Apache Derby wielkość zbioru danych: "+dataSetSize);
        start = System.nanoTime();
        derby.insert(dataSet, "people_info");
        end = System.nanoTime();
        elapsedTimeInsert = (end-start)/1000000;

        start = System.nanoTime();
        derby.select();
        end = System.nanoTime();
        elapsedTimeSelect = (end-start)/1000000;

        start = System.nanoTime();
        derby.delete();
        end = System.nanoTime();
        elapsedTimeDelete = (end-start)/1000000;


        System.out.println("\tInsert\t|\tSelect\t|\tDelete\n");
        System.out.print("\t"+elapsedTimeInsert+"ms\t|\t"+elapsedTimeSelect+"ms\t|\t"+elapsedTimeDelete+"ms\n");
    }

    public static void mongoTest(DataSet dataSet) throws Exception {
        int dataSetSize = dataSet.getSize();
        long start;
        long end;
        long elapsedTimeSelect;
        long elapsedTimeInsert;
        long elapsedTimeDelete;

        MongoDbProfiler mongodb = new MongoDbProfiler();
        System.out.println("MONGODB wielkość zbioru danych: "+dataSetSize);

        start = System.nanoTime();
        mongodb.insert(dataSet,"");
        end = System.nanoTime();
        elapsedTimeInsert = (end - start)/1000000;

        start = System.nanoTime();
        mongodb.select();
        end = System.nanoTime();
        elapsedTimeSelect = (end - start)/1000000;

        start = System.nanoTime();
        mongodb.delete();
        end = System.nanoTime();
        elapsedTimeDelete = (end - start)/1000000;

        System.out.println("\tInsert\t|\tSelect\t|\tDelete\n");
        System.out.print("\t"+elapsedTimeInsert+"ms\t|\t"+elapsedTimeSelect+"ms\t|\t"+elapsedTimeDelete+"ms\n");
    }

    public static void couchDbTest(DataSet dataSet) throws Exception {
        int dataSetSize = dataSet.getSize();
        long start;
        long end;
        long elapsedTimeSelect;
        long elapsedTimeInsert;
        long elapsedTimeDelete;

        CouchDbProfiler couchDb = new CouchDbProfiler("http://admin:123@localhost:5984" , "people_2");

        System.out.println("CouchDB wielkość zbioru danych: "+dataSetSize);
        start = System.nanoTime();
        couchDb.insert(dataSet,"");
        end = System.nanoTime();
        elapsedTimeInsert = (end - start)/1000000;

        start = System.nanoTime();
        couchDb.select();
        end = System.nanoTime();
        elapsedTimeSelect = (end - start)/1000000;

        start = System.nanoTime();
        couchDb.delete();
        end = System.nanoTime();
        elapsedTimeDelete = (end - start)/1000000;

        System.out.println("\tInsert\t|\tSelect\t|\tDelete\n");
        System.out.print("\t"+elapsedTimeInsert+"ms\t|\t"+elapsedTimeSelect+"ms\t|\t"+elapsedTimeDelete+"ms\n");


    }

    public static void cassandraTest(DataSet dataSet) throws Exception {

        int dataSetSize = dataSet.getSize();
        long start;
        long end;
        long elapsedTimeSelect;
        long elapsedTimeInsert;
        long elapsedTimeDelete;

        CassandraProfiler cassandra = new CassandraProfiler("127.0.0.1",9042);

        System.out.println("Cassandra wielkość zbioru danych: "+dataSetSize);
        start = System.nanoTime();
        cassandra.insert(dataSet,"people_info");
        end = System.nanoTime();
        elapsedTimeInsert = (end - start)/1000000;

        start = System.nanoTime();
        cassandra.select();
        end = System.nanoTime();
        elapsedTimeSelect = (end - start)/1000000;

        start = System.nanoTime();
        cassandra.delete();
        end = System.nanoTime();
        elapsedTimeDelete = (end - start)/1000000;
        cassandra.close();

        System.out.println("\tInsert\t|\tSelect\t|\tDelete\n");
        System.out.print("\t"+elapsedTimeInsert+"ms\t|\t"+elapsedTimeSelect+"ms\t|\t"+elapsedTimeDelete+"ms\n");
    }

    public static void main(String[] args) throws Exception {
        int dataSetSizeV1 = 50000;
        int dataSetSizeV2 = 100000;
        int dataSetSizeV3 = 150000;
        int dataSetSizeV4 = 200000;
        int dataSetSizeV5 = 250000;

        DataSet dataSetV1 = new DataSet(dataSetSizeV1, true);
        DataSet dataSetV2 = new DataSet(dataSetSizeV2, true);
        DataSet dataSetV3 = new DataSet(dataSetSizeV3, true);
        DataSet dataSetV4 = new DataSet(dataSetSizeV4, true);
        DataSet dataSetV5 = new DataSet(dataSetSizeV5, true);

//        mySQLTest(dataSetV1);
//        mySQLTest(dataSetV2);
//        mySQLTest(dataSetV3);
//        postgresTest(dataSetV1);
//        postgresTest(dataSetV2);
//        postgresTest(dataSetV3);
//        derbyTest(dataSetV1);
//        derbyTest(dataSetV2);
//        derbyTest(dataSetV3);
//        mongoTest(dataSetV1);
//        mongoTest(dataSetV2);
//        mongoTest(dataSetV3);
        couchDbTest(dataSetV1);
//        couchDbTest(dataSetV2);
//        couchDbTest(dataSetV3);
//        cassandraTest(dataSetV1);
//        cassandraTest(dataSetV2);
//        cassandraTest(dataSetV3);


    }
}
