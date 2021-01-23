package com.company;

import com.company.model.DataSet;

public interface Profiler {
    void insert(DataSet dataSet, String tableName);
    void delete(String tableName);
    void select(String tableName);


}
