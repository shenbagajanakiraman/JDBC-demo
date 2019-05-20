package com.stackroute;

import com.stackroute.db.CrudOperation;
import com.stackroute.db.JDBCTransactionDemo;
import com.stackroute.db.ResultsetMetadataDemo;
import com.stackroute.db.RowsetDemo;

public class Main {
    public static void main(String[] args) throws Exception{
//        CrudOperation crudOperation = new CrudOperation();
//        crudOperation.displayData();
//        crudOperation.displayCustomrerByName("Arjun","Male");
//        ResultsetMetadataDemo rsDemo = new ResultsetMetadataDemo();
//        rsDemo.displayData();

//        RowsetDemo rowsetDemo = new RowsetDemo();
//        rowsetDemo.displayData();

        JDBCTransactionDemo jdbcTransactionDemo = new JDBCTransactionDemo();
        jdbcTransactionDemo.jdbcTransaction();


    }
}
