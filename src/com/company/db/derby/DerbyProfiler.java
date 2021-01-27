package com.company.db.derby;

import com.company.Profiler;
import com.company.model.DataSet;
import com.company.model.MySqlQueryCreator;

import java.sql.*;

public class DerbyProfiler implements Profiler {

    private static String dbURL = "jdbc:derby://localhost:1527/dbs;create=true";
    private static String tableName = "people_info";

    // jdbc Connection
    private static Connection connection = null;
    private static Statement stmt = null;

    public DerbyProfiler() throws SQLException {
        createConnection();
        connection.createStatement().execute("DROP TABLE people_info");
        connection.createStatement().execute("CREATE TABLE people_info " +
                "(" +
                "name CHAR(120)," +
                "secondname CHAR(120)," +
                "age CHAR(120), " +
                "state CHAR (120)" +
                ")");
    }

    @Override
    public void insert(DataSet dataSet, String tableName) {

        for (int i = 0; i < dataSet.getSize(); i += 1000) {
            DataSet rangeCopy = new DataSet(dataSet, i, i + 1000);
            String query = new MySqlQueryCreator().mySqlInsert(rangeCopy, tableName);
            try {
                stmt = connection.createStatement();
                stmt.execute(query.substring(0, query.length() - 1));
                stmt.close();
            } catch (SQLException sqlExcept) {
                sqlExcept.printStackTrace();
            }
        }
    }

    @Override
    public void select() {
        try {
            stmt = connection.createStatement();
            stmt.execute("SELECT * FROM people_info");
            stmt.close();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }

    }

    @Override
    public void delete() {
        try {
            stmt = connection.createStatement();
            stmt.execute("TRUNCATE TABLE people_info");
            stmt.close();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }

    }

    private void createConnection() {
        try {
//            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            //Get a connection
            connection = DriverManager.getConnection(dbURL);
        } catch (Exception except) {
            except.printStackTrace();
        }
    }

    public void select(String tableName) {
        try {
            stmt = connection.createStatement();
            ResultSet results = stmt.executeQuery("select * from " + tableName);
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i = 1; i <= numberCols; i++) {
                //print Column Names
                System.out.print(rsmd.getColumnLabel(i) + "\t");
            }

            while (results.next()) {
                String id = results.getString(1);
                String restName = results.getString(2);
                String cityName = results.getString(3);
                System.out.println(id + "\t" + restName + "\t" + cityName);
            }
            results.close();
            stmt.close();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
    }

    private static void shutdown() {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (connection != null) {
                DriverManager.getConnection(dbURL + ";shutdown=true");
                connection.close();
            }
        } catch (SQLException ignored) {
        }

    }
}
