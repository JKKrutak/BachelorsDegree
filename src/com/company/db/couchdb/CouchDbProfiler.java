package com.company.db.couchdb;
import com.company.Profiler;
import com.company.model.DataSet;
import com.company.model.User;
import org.apache.commons.io.IOUtils;
import org.ektorp.*;
import org.ektorp.impl.*;
import org.ektorp.http.*;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.Reference;
import java.util.*;

public class CouchDbProfiler implements Profiler {
    CouchDbInstance dbInstance;
    CouchDbConnector db;
    HttpClient httpClient;
    String database;


    public CouchDbProfiler(String url, String database) throws Exception {
        HttpClient httpClient = new StdHttpClient.Builder()
                .url(url) //http://localhost:5984
                .socketTimeout(50000)
                .build();

        this.httpClient = httpClient;
        this.database = database;

        dbInstance = new StdCouchDbInstance(httpClient);
        db = new StdCouchDbConnector(database, dbInstance);
        db.createDatabaseIfNotExists();
    }

    @Override
    public void insert(DataSet dataSet, String tableName){


        List<Map<String, Object>> objects = new ArrayList<>(dataSet.getSize());

        for(int i = 1; i < dataSet.getSize()+1; i++) {
            Map<String, Object> referenceData = new HashMap<String, Object>();
            referenceData.put("id", i);
            referenceData.put("name", dataSet.getRandomNames()[i-1]);
            referenceData.put("surrname", dataSet.getRandomSurrnames()[i-1]);
            referenceData.put("age", dataSet.getRandomAges()[i-1]);
            referenceData.put("state", dataSet.getRandomStates()[i-1]);

            objects.add(referenceData);

//            db.create(referenceData);
        }

//        db.create(objects);
        db.executeBulk(objects);
    }

    @Override
    public void select() {
        List<String> data = new ArrayList<>();
        for(String id : db.getAllDocIds()) {
            try {
                InputStream stream = db.getAsStream(id);
                String record = IOUtils.toString(stream);
                stream.close();
                data.add(record);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //System.out.println(data);
    }

    @Override
    public void delete() {
        try {
            List<String> ids = db.getAllDocIds();
            //System.out.println(ids.get(2));

            for(String id : ids) {
                for(Revision revision : db.getRevisions(id)) {
                    db.delete(id, revision.getRev());
                }
            }

        }
        catch (Exception e)
        {
            System.out.println(e);
        }


        //System.out.println(ids);

    }




        //Wyciąganie usera
//        User user2 = db.get(User.class, "ektorp");
//        System.out.println("User z bazy: " + user2.getId() + ":" + user2.getName());
}

