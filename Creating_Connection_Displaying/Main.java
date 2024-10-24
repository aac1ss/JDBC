package JDBC.Creating_Connection_Displaying;
import java.sql.*;

public class Main {
    public static void main(String[] args)  {

        //1. importing url, username, password of DataBase
        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="ashish";
        String query="Select * from employees;";

        //2. Loading Drivers
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers Loaded Succesfullhy");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //3. Establishing Connection
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established Succesfullhy");

             //4. Creating Statement(i.e Writing Query) (takes no Argument)
            Statement stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String  job_title = rs.getString("job_title");
                double salary=rs.getDouble("salary");
                System.out.println("Id: "+id);
                System.out.println("Name: "+name);
                System.out.println("Job Title: "+job_title);
                System.out.println("Salary: "+salary);
                System.out.println("----------------------------");
            }
            rs.close();
            stmt.close();
            con.close();
            System.out.println("Connection Closed Succesfullhy");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

}
