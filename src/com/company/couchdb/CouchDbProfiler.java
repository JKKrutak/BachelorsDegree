package com.company.couchdb;
import com.company.Profiler;
import com.company.model.DataSet;
import com.company.model.User;
import org.ektorp.*;
import org.ektorp.impl.*;
import org.ektorp.http.*;

import java.util.UUID;
public class CouchDbProfiler implements Profiler {
    CouchDbInstance dbInstance;
    CouchDbConnector db;


    public CouchDbProfiler(String url, String database) throws Exception {
        HttpClient httpClient = new StdHttpClient.Builder()
                .url(url) //http://localhost:5984
                .build();

        dbInstance = new StdCouchDbInstance(httpClient);
        db = new StdCouchDbConnector(database, dbInstance);
        db.createDatabaseIfNotExists();
    }

    @Override
    public void insert(DataSet dataSet, String tableName){

        User user = new User("1","Jakub");
        db.create(UUID.randomUUID().toString(), user);
    }




        //Wyciąganie usera
//        User user2 = db.get(User.class, "ektorp");
//        System.out.println("User z bazy: " + user2.getId() + ":" + user2.getName());
}

