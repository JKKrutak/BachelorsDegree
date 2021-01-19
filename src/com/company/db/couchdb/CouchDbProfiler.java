package com.company.db.couchdb;
import com.company.Profiler;
import com.company.model.DataSet;
import com.company.model.User;
import org.ektorp.*;
import org.ektorp.impl.*;
import org.ektorp.http.*;
import java.util.Map;
import java.util.HashMap;

public class CouchDbProfiler implements Profiler {
    CouchDbInstance dbInstance;
    CouchDbConnector db;
    HttpClient httpClient;
    String database;


    public CouchDbProfiler(String url, String database) throws Exception {
        HttpClient httpClient = new StdHttpClient.Builder()
                .url(url) //http://localhost:5984
                .build();

        this.httpClient = httpClient;
        this.database = database;

    }

    @Override
    public void insert(DataSet dataSet, String tableName){

        dbInstance = new StdCouchDbInstance(httpClient);
        //db = new StdCouchDbConnector(database, dbInstance);
        db = new StdCouchDbConnector(database, dbInstance);
        db.createDatabaseIfNotExists();

        User user = new User("1","ENODZIAŁA");
        //db.create(UUID.randomUUID().toString(), user);

        for(int i = 1; i < dataSet.getSize()+1; i++) {
            Map<String, Object> referenceData = new HashMap<String, Object>();
            referenceData.put("id", i);
            referenceData.put("name", dataSet.getRandomNames()[i-1]);
            referenceData.put("surrname", dataSet.getRandomSurrnames()[i-1]);
            referenceData.put("age", dataSet.getRandomAges()[i-1]);
            referenceData.put("state", dataSet.getRandomStates()[i-1]);
            db.create(referenceData);
        }






        //System.out.println(referenceData);
       // db.create(referenceData);

    }




        //Wyciąganie usera
//        User user2 = db.get(User.class, "ektorp");
//        System.out.println("User z bazy: " + user2.getId() + ":" + user2.getName());
}

