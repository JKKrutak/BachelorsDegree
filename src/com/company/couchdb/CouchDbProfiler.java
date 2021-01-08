package com.company.couchdb;
import com.company.model.User;
import org.ektorp.*;
import org.ektorp.impl.*;
import org.ektorp.http.*;

import java.util.UUID;


public class CouchDbProfiler {

    public CouchDbProfiler(String url, String database) throws Exception{
        HttpClient httpClient = new StdHttpClient.Builder()
                .url(url) //http://localhost:5984
                .build();


        CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);
        CouchDbConnector db = new StdCouchDbConnector(database, dbInstance);
        db.createDatabaseIfNotExists();

        User user = new User("1","Jakub");
        db.create(UUID.randomUUID().toString(), user);

        //Wyciąganie usera
//        User user2 = db.get(User.class, "ektorp");
//        System.out.println("User z bazy: " + user2.getId() + ":" + user2.getName());
    }



}

