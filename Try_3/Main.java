package JDBC.Try_3;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
    //1. connecting to Db
        String url="jdbc:mysql://localhost:3306/mydatabase";
        String user="root";
        String password="ashish";
        String query="Select * from employees;";
        System.out.println("Connecting to Db...");
   //2. Connecting DriverManager
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting to DRiver...");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    //3. Connecting JDBC and DB
        try {
            Connection con=DriverManager.getConnection(url,user,password);
            System.out.println("Establishing connection...");
            Statement stmt =con.createStatement();
            System.out.println("Executing Sql Statements...");
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("Retrieving the Result of the Sql QuerY...");
            while (rs.next()) {
            int id=rs.getInt("Id");
            String name=rs.getString("Name");
            String job_title=rs.getString("Job_Title");
            double salary=rs.getDouble("salary");


                System.out.println("Id: "+id);
                System.out.println("Name: "+name);
                System.out.println("Job Title: "+job_title);
                System.out.println("Salary: "+salary);
                System.out.println("----------------------------");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
