package com.company.postgres;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostgresProfiler {
    public void connect() throws Exception {
        Connection c = null;
        try
        {
            Class.forName("org.postgresql.Driver");
            c =  ConnectionHelper.getConnection("jdbc:postgresql://localhost:52/tttest");
            Statement stm = c.createStatement();
            //stm.executeQuery("use test;");
            ResultSet rs = stm.executeQuery("SELECT * FROM pionki");

            while (rs.next()) {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            c.close();
        }
    }
}

