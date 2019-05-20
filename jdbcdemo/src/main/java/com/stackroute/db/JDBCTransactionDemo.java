package com.stackroute.db;

import java.sql.*;

public class JDBCTransactionDemo {
    private Connection con;

    public void displayData() {
        try {
            //Resister Driver with driver manager service
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Driver loaded");//create connection
            //here db1 is database name, root is username and root123 is password
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/customerdb", "root", "Root@123");
            //create statement object
            System.out.println("got connected");

            PreparedStatement ps = con.prepareStatement("select * from customerdetails");
            ResultSet rs = ps.executeQuery("Select name,age from customerdetails");
            ResultSetMetaData rsmd = rs.getMetaData();

            System.out.println("Total columns: " + rsmd.getColumnCount());
            System.out.println("Column Name of 1st column: " + rsmd.getColumnName(1));
            System.out.println("Column Type Name of 1st column: " + rsmd.getColumnTypeName(1));


        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


