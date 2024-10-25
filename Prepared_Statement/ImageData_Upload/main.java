package JDBC.Prepared_Statement.ImageData_Upload;

import java.io.*;
import java.sql.*;

public class main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "root";
        String password = "ashish";
        String driver = "com.mysql.cj.jdbc.Driver";
        String image_path="C:\\Users\\thapa\\Downloads\\wallpaperflare.com_wallpaper.jpg";
        String query= "INSERT INTO image_table(image_data) VALUES(?)";

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection conn=DriverManager.getConnection(url,user,password);
            System.out.println("Connected to database...");
            FileInputStream fis = new FileInputStream(image_path);
            byte[] image_data= new byte[fis.available()]    ;
            fis.read(image_data);
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setBytes(1,image_data);
            int affected_rows = ps.executeUpdate();
            if(affected_rows>0){
                System.out.println("Image Uploaded SuccessFully");
            }
            else {
                System.out.println("Image Not Uploaded");
            }

            conn.close();
            System.out.println("Connection closed... SUCE$$FullY");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
