package JDBC.Normal_Statement.inserting_data;
import java.sql.*;

public class main2 {
    public static void main(String[] args) {
        //1.  Connecting to the Db:
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "root";
        String password = "ashish";
        String driver = "com.mysql.cj.jdbc.Driver";
        String query= "insert into employees(id,name,job_title,salary) values(3,'Jett','Designer',48000); ";
        System.out.println("Connecting to the Db....");

        //2. Establishing connection to the DriverManager:
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Establishing connection to the DriverManager...");

        //3. Establishing Connectiong with Java and Database:
        try {

            Connection con=DriverManager.getConnection(url,user,password);
            System.out.println("Establishing Connectiong with Java and Database....");
            //4. Taking QUery Statement
            Statement st=con.createStatement();
            System.out.println("Taking QUery Statement...");

            //5. Executing QUery Statement
           /* int rowsAffected =st.executeUpdate(query);
            System.out.println("Executing QUery Statement");
            if(rowsAffected>0){
                System.out.println("Successfully executed QUery Statement");
            }
            else {
                System.out.println("Failed to execute QUery Statement");
            }*/
            ResultSet rs=st.executeQuery("Select * from employees");
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String job_title=rs.getString("job_title");
                double salary=rs.getDouble("salary");
                System.out.println("|"+id+"\t"+"|"+name+"\t"+"|"+job_title+"\t|"+salary+"|");
            }
            st.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }
}
