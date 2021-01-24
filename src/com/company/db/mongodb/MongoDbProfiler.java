package com.company.db.mongodb;

import com.company.Profiler;
import com.company.model.DataSet;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;


import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MongoDbProfiler implements Profiler {
    private MongoCollection<Document> collection;

    public MongoDbProfiler(){
        try {
            MongoClient mongoClient = new MongoClient("localhost",27017);
            MongoDatabase database = mongoClient.getDatabase("people");
//            database.createCollection("pionkidwa", null);
            collection = database.getCollection("people_info");
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
             document.put("secondname", dataSet.getRandomSurrnames()[i]);
             document.put("age", dataSet.getRandomAges()[i]);
             document.put("state", dataSet.getRandomStates()[i]);

             listOfDocuments.add(document);
        }
        collection.insertMany(listOfDocuments);
    }

    @Override
    public void select() {
        Document find = new Document().append("name","Sienna");
        collection.find(find);
        //List results = new ArrayList<>();
        //collection.find(find).into(results);
    }

    @Override
    public void delete() {
        collection.drop();

    }


    public void closeConnection() {

    }
}

