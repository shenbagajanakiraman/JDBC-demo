package com.stackroute.db;

import java.sql.*;

public class CrudOperation {
    private Connection con;

    public void displayData() {
        try (
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "Root@123");
           Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery("select * from customerdetails");) {

            //Resister Driver with driver manager service
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Driver loaded");//create connection
            //here db1 is database name, root is username and root123 is password
//            con = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/customerdb", "root", "Root@123");
            //create statement object
            System.out.println("got connected");

//            Statement stmt = con.createStatement();


            //execute query
//            ResultSet rs = stmt.executeQuery("select * from customerdetails");

            rs.absolute(3);
            System.out.println("Printing only third row...");

            System.out.println(rs.getInt(1) + "  " + rs.getString(2)+"  "+ rs.getInt(3));



            System.out.println("Continuing....");
            //process result
            while (rs.next())
                System.out.println(rs.getInt(1) + "  " + rs.getString(2)+"  "+ rs.getInt(3));

            rs.afterLast();
            System.out.println("Printing in reverse order...");
            while (rs.previous())
                System.out.println(rs.getInt("id") + "  " + rs.getString("name")+"  "+ rs.getInt("age"));


            System.out.println("Only last 2");


            rs.last();
            while (rs.previous())
                System.out.println(rs.getInt("id") + "  " + rs.getString("name")+"  "+ rs.getInt("age"));


        } catch (Exception e) {
            System.out.println(e);
        }
//        finally {
//            try {
//                con.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
        }




    public void displayCustomrerByName(String name, String gender) {

        try{
            //Resister Driver with driver manager service
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");//create connection
            //here db1 is database name, root is username and root123 is password
            con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/customerdb","root","Root@123");
            //create statement object
            System.out.println("got connected");

            PreparedStatement stmt=con.prepareStatement("Select * from customerdetails where name=? and gender = ?");
            stmt.setString(1,name);
            stmt.setString(2,gender);
            ResultSet rs = stmt.executeQuery();
//            System.out.println("ID "+rs2.getInt(1)+"  "+rs2.getString(2));
            //execute query
//            ResultSet rs1=stmt.executeQuery("select * from customerdetails");
            //process result
            while(rs.next())
                System.out.println(rs.getString(1)+"  "+rs.getString(2));
            con.close();
        }catch(Exception e){ System.out.println(e);}
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void insertCustomer(int id, String name) {

        //PreparedStatement
    }
    }
