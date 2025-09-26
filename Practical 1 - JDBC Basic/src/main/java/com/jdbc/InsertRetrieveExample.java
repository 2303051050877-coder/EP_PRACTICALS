package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertRetrieveExample {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/practicals_db";
        String user = "root";
        String password = "shivansh@mishra";

        try {
            // 1. Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Create connection
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Database connected successfully!");

            // 3. Create Statement
            Statement stmt = con.createStatement();

            // 4. Insert a record
            String insertQuery = "INSERT INTO students(name, age) VALUES('Shivansh Mishra', 21)";
            int rowsInserted = stmt.executeUpdate(insertQuery);
            System.out.println(rowsInserted + " record(s) inserted.");

            // 5. Retrieve records
            String selectQuery = "SELECT * FROM students";
            ResultSet rs = stmt.executeQuery(selectQuery);

            System.out.println("Student Records:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.println(id + " | " + name + " | " + age);
            }

            // 6. Cleanup
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
