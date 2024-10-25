package JDBC.Normal_Statement.inserting_data;
import java.sql.*;

public class main3 {
    public static void main(String[] args) {
    // connecting Database;
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "root";
        String password = "ashish";
        String driver = "com.mysql.cj.jdbc.Driver";
        String query= "Insert into employees(id,name,job_title,salary) values(5,'Reyna','Q.A',39000)";

    // Loading Drivers
        try {
            Class.forName(driver);
            System.out.println("---x---Drivers Loaded---x---");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Connecting DB and Java
        try {
            Connection conn=DriverManager.getConnection(url,user,password);
            System.out.println("---x---Connected SucessFully---x---");
            Statement st=conn.createStatement();
            System.out.println("---x---Creating Statement---x---");
            // Executing Update Query (adding new Elements)
            int rowsAffected = st.executeUpdate(query);
            System.out.println("---x---ADding new Query---x---");
            if(rowsAffected>0){
                System.out.println("Rows affected: "+rowsAffected);
            }
            else {
                System.out.println("No rows affected");
            }

            // Displaying all the Things in the DataBase.
            ResultSet resultSet = st.executeQuery("Select * from employees");
            System.out.println("Getting all details of the Database....");
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String job_title = resultSet.getString("job_title");
                Double salary = resultSet.getDouble("salary");
                System.out.println(id+" "+name+" "+job_title+" "+salary);
            }
            resultSet.close();
            st.close();
            conn.close();




        } catch (SQLException e) {
            System.out.println();
        }


    }
}
