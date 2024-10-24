package JDBC.Try_2;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
  //1. Adding urls
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "root";
        String password = "ashish";
        String query="Select salary from employees";
        System.out.println("Connecting to database...");
        //2. Connecting with Driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("[ Java -> Connected -> Database ]");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            //3. Java ra Db sanga connection establish gareko
            Connection con=DriverManager.getConnection(url,user,password);
            Statement stmt=con.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()){
                System.out.println("Salary is:"+resultSet.getString("salary"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
