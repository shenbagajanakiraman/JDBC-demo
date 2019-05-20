package com.stackroute;

import com.stackroute.db.*;

public class Main {
    public static void main(String[] args) throws Exception{

//        CrudOperation crudOperation = new CrudOperation();
//        crudOperation.displayData();
//        crudOperation.displayCustomrerByName("Arjun","Male");
//        ResultsetMetadataDemo rsDemo = new ResultsetMetadataDemo();
//        rsDemo.displayData();
//
//        RowsetDemo rowsetDemo = new RowsetDemo();
//        rowsetDemo.displayData();

//        JDBCTransactionDemo jdbcTransactionDemo = new JDBCTransactionDemo();
//        jdbcTransactionDemo.jdbcTransaction();


//        JDBCBatchProcessingDemo jdbcBatchProcessingDemo = new JDBCBatchProcessingDemo();
//        jdbcBatchProcessingDemo.jdbcBatchProcessing();

        DataBaseMetaDataDemo dataBaseMetaDataDemo = new DataBaseMetaDataDemo();
        dataBaseMetaDataDemo.metadataDisplay();


    }
}
