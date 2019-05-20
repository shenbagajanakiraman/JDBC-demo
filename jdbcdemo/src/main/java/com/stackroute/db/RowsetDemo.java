package com.stackroute.db;

        import javax.sql.rowset.JdbcRowSet;
        import javax.sql.rowset.RowSetProvider;
        import java.sql.*;

public class RowsetDemo {
    //demo of connected rowset
    private Connection con;
    public void displayData() {
        try{
            //Resister Driver with driver manager service
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");//create connection


             JdbcRowSet rowSet =   RowSetProvider.newFactory().createJdbcRowSet();
            rowSet.setUrl("jdbc:mysql://localhost:3306/customerdb");
            rowSet.setUsername("root");
            rowSet.setPassword("Root@123");

            rowSet.setCommand("select * from customer");
            rowSet.execute();
            while(rowSet.next())
            {
                System.out.println(rowSet.getString(1));
            }



        }catch(Exception e){ System.out.println(e);}
        finally {
//            try {
////                con.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
        }
    }




}



