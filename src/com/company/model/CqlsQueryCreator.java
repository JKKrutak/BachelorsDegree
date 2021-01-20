package com.company.model;


public class CqlsQueryCreator {
    public String cqlsInsert(DataSet dataSet, String tableName){
        String query;
        int amountOfData = dataSet.getSize();
        //BEGIN BATCH INSERT INTO people.people_info (id, name, secondname, age, state) values (uuid(),'Rafal', 'Adamek', 25, 'malopolskie'); APPLY BATCH;
        query = "BEGIN BATCH ";
        for(int i = 0; i < amountOfData; i++) {
            query = query + "INSERT INTO people."+tableName+"(id, name, secondname, age, state) VALUES (uuid(),";
            query = query + "'" + dataSet.getRandomNames()[i] + "',";
            query = query + "'" + dataSet.getRandomSurrnames()[i] + "',";
            query = query + "" + dataSet.getRandomAges()[i] + ",";
            query = query + "'" + dataSet.getRandomStates()[i] + "');\n";
        }
        query = query.substring(0,query.length()-2).trim() + ';';
        query = query + "APPLY BATCH;";

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
