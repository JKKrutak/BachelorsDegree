package com.company.mysql;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySqlProfiler {
    public void connect() throws Exception {
        Connection c = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c =  ConnectionHelper.getConnection("jdbc:mysql://localhost:50");
            Statement stm = c.createStatement();
            stm.executeQuery("use test;");
            ResultSet rs = stm.executeQuery("Select * from testtable;");

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

