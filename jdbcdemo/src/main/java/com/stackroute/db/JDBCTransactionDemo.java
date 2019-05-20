package com.stackroute.db;

import java.sql.*;


public class JDBCTransactionDemo {

    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/customerdb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Root@123";

    public void jdbcTransaction() throws SQLException {

        Connection dbConnection = null;
        PreparedStatement preparedStatementInsert = null;
        PreparedStatement preparedStatementUpdate = null;

        String insertTableSQL = "INSERT INTO customerdetails"
                + "(NAME, age, gender) VALUES"
                + "(?,?,?)";

        String updateTableSQL = "UPDATE customerdetails SET USERNAME =? "
                + "WHERE USER_ID = ?";

        try {
            dbConnection = getDBConnection();

            dbConnection.setAutoCommit(false);

            preparedStatementInsert = dbConnection.prepareStatement(insertTableSQL);

            preparedStatementInsert.setString(1, "Prabha");
            preparedStatementInsert.setInt(2, 45);
            preparedStatementInsert.setString(3, "Female");

            preparedStatementInsert.executeUpdate();

//            preparedStatementUpdate = dbConnection.prepareStatement(updateTableSQL);
//            // preparedStatementUpdate.setString(1,
//            // "A very very long string caused db error");
//            preparedStatementUpdate.setString(1, "new string");
//            preparedStatementUpdate.setInt(2, 999);
//            preparedStatementUpdate.executeUpdate();

            dbConnection.commit();

            System.out.println("Done!");
            Statement stmt = dbConnection.createStatement();

            ResultSet rs = stmt.executeQuery("select * from customerdetails");
            while (rs.next())
                System.out.println(rs.getInt(1) + "  " + rs.getString(2)+"  "+ rs.getInt(3));




        } catch (SQLException e) {

            System.out.println(e.getMessage());
            dbConnection.rollback();

        } finally {

            if (preparedStatementInsert != null) {
                preparedStatementInsert.close();
            }

            if (preparedStatementUpdate != null) {
                preparedStatementUpdate.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

        }

    }

    private static Connection getDBConnection() {

        Connection dbConnection = null;

        try {

            Class.forName(DB_DRIVER);

        } catch (ClassNotFoundException e) {

            System.out.println(e.getMessage());

        }

        try {

            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
                    DB_PASSWORD);
            return dbConnection;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return dbConnection;

    }



}


