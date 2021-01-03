package com.company;

import com.company.mysql.MySqlProfiler;

public class Main {
    public static void main(String[] args) throws Exception {

        MySqlProfiler mysql = new MySqlProfiler();

        mysql.connect();


    }
}
