package com.company.model;


public class MySqlQueryCreator {
    public String mySqlInsert(DataSet dataSet, String tableName){
        String query;
        int amountOfData = dataSet.getSize();
        query = "INSERT INTO "
                +tableName+
                " (name, secondname, age, state) VALUES";

        for(int i = 0; i < amountOfData; i++) {
            query = query + "('" + dataSet.getRandomNames()[i] + "',";
            query = query + "'" + dataSet.getRandomSurrnames()[i] + "',";
            query = query + "'" + dataSet.getRandomAges()[i] + "',";
            query = query + "'" + dataSet.getRandomStates()[i] + "'),\n";
        }
            query = query.substring(0,query.length()-2).trim() + ';';

        return query;
    }
/*
    public String couchDbInsert(int amountOfData, String tableName) {
        String query;
        Random rand = new Random();
        query = "INSERT INTO "
                +tableName+
                " (name, secondname, age, state) VALUES";



        return query;
    }
*/
}
