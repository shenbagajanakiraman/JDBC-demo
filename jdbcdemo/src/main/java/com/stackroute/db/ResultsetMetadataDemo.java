package com.stackroute.db;

import java.sql.*;

public class ResultsetMetadataDemo {
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
            ResultSet rs=ps.executeQuery("Select name,age from customerdetails");
            ResultSetMetaData rsmd =rs.getMetaData();

            System.out.println("Total columns: "+rsmd.getColumnCount());
            System.out.println("Column Name of 1st column: "+rsmd.getColumnName(1));
            System.out.println("Column Type Name of 1st column: "+rsmd.getColumnTypeName(1));




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


//
//    public void displayCustomrerByName(String name, String gender) {
//
//        try{
//            //Resister Driver with driver manager service
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            System.out.println("Driver loaded");//create connection
//            //here db1 is database name, root is username and root123 is password
//            con= DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/customerdb","root","Root@123");
//            //create statement object
//            System.out.println("got connected");
//
//            PreparedStatement stmt=con.prepareStatement("Select * from customerdetails where name=? and gender = ?");
//            stmt.setString(1,name);
//            stmt.setString(2,gender);
//            ResultSet rs = stmt.executeQuery();
////            System.out.println("ID "+rs2.getInt(1)+"  "+rs2.getString(2));
//            //execute query
////            ResultSet rs1=stmt.executeQuery("select * from customerdetails");
//            //process result
//            while(rs.next())
//                System.out.println(rs.getString(1)+"  "+rs.getString(2));
//            con.close();
//        }catch(Exception e){ System.out.println(e);}
//        finally {
//            try {
//                con.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public void insertCustomer(int id, String name) {
//
//        //PreparedStatement
//    }
}

