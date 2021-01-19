package com.company.db.cassandra;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class CassandraConnector {

    private Cluster cluster;

    private Session session;

    public void connect(String node, Integer port) {
        Cluster.Builder b = Cluster.builder().addContactPoint("127.0.0.1");
        if (port != null) {
            b.withPort(port);
        }
        cluster = b.build();

        session = cluster.connect();
    }

    public void query(String query) {
        session.execute(query);
    }

    public void close() {
        session.close();
        cluster.close();
    }




}