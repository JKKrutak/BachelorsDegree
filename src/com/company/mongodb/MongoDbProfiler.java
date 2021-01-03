package com.company.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;

public class MongoDbProfiler {

    public MongoDbProfiler(){

    }


    public void connect() throws Exception {
        Connection c = null;
        try
        {
            MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:53"));
            MongoDatabase database = mongoClient.getDatabase("pionki");
            MongoCollection collection = database.getCollection("user");

            Iterator it = collection.find().iterator();

            while(it.hasNext()) {
                System.out.println(it.next());
            }


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}

