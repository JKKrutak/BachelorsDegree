package com.company.mongodb;

import com.company.ConnectionHelper;
import com.company.Profiler;
import com.company.model.DataSet;
import com.company.model.MySqlQueryCreator;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mysql.cj.protocol.a.MysqlBinaryValueDecoder;
import org.bson.Document;


import javax.print.Doc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MongoDbProfiler implements Profiler {
    private MongoCollection<Document> collection;

    public MongoDbProfiler(){
        try {
            MongoClient mongoClient = new MongoClient("localhost",53);
            MongoDatabase database = mongoClient.getDatabase("pionkidwa");
//            database.createCollection("pionkidwa", null);
            collection = database.getCollection("pionkidwa");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(DataSet dataSet, String tableName){

        Logger.getLogger("org.mongodb.driver").setLevel(Level.ALL);

        List<Document> listOfDocuments = new LinkedList<>(); // Linked lista gdyż ponieważ będzie szybsza
        for(int i = 0; i < dataSet.getSize(); i++) {
             Document document = new Document();
             document.put("name", dataSet.getRandomNames()[i]);
             document.put("surrname", dataSet.getRandomSurrnames()[i]);
             document.put("age", dataSet.getRandomAges()[i]);
             document.put("state", dataSet.getRandomStates()[i]);

             listOfDocuments.add(document);
        }

        collection.insertMany(listOfDocuments);



    }

    public void closeConnection() {

    }
}

