package JDBC.inserting_data;
import java.sql.*;

public class main {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/mydatabase";
        String user="root";
        String password="ashish";
        String driver="com.mysql.cj.jdbc.Driver";
        String query ="insert into employees(id,name,job_title,salary) values(4,'Cypher','Camera-Man',40000);";


        System.out.println("Connecting to database...");

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            Connection conn=DriverManager.getConnection(url,user,password);

            Statement st=conn.createStatement();

           int rowsAffected =st.executeUpdate(query);
            System.out.println("Executing Query");
            if (rowsAffected >0){
                System.out.println("Query Inserted");
            }
            else {
                System.out.println("Query Not Inserted");
            }
            ResultSet rs=st.executeQuery("select * from employees");
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String job_title=rs.getString("job_title");
                double salary=rs.getDouble("salary");
                System.out.println(id+" "+name+" "+job_title+" "+salary);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
