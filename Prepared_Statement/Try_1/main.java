package JDBC.Prepared_Statement.Try_1;

import java.sql.*;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "root";
        String password = "ashish";
        String driver = "com.mysql.cj.jdbc.Driver";
        String query= "Select * from employees where id=(?)";
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            Connection conn=DriverManager.getConnection(url,user,password);
            System.out.println("Connected to database...");
            PreparedStatement ps=conn.prepareStatement(query);
            System.out.println("Prepared Statement...");
            System.out.println("Enter the Id of the Employee: ");
            int chk=sc.nextInt();
            ps.setString(1, String.valueOf(chk));
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String job_title=rs.getString("job_title");
                int salary=rs.getInt("salary");
                System.out.println("Id: " + id);
                System.out.println("Name: " + name);
                System.out.println("Job Title: " + job_title);
                System.out.println("Salary: " + salary);
            }
            rs.close();
            ps.close();
            conn.close();
            System.out.println("Connection closed... SUCE$$FullY");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
