package JDBC.Prepared_Statement.ImageData_Retrieval;

import java.io.*;
import java.sql.*;

public class main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "root";
        String password = "ashish";
        String driver = "com.mysql.cj.jdbc.Driver";
        String image_path="C:\\Users\\thapa\\Downloads\\wallpaperflare.com_wallpaper.jpg";
        String image_path_2="C:\\Users\\thapa\\Downloads\\";
        String query= "Select image_data from image_table where image_id=(?)";

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());;
        }

        try {
            Connection conn=DriverManager.getConnection(url,user,password);
            System.out.println("Connected to database...");
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setInt(1,1);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                byte[] image_data=rs.getBytes("image_data");
                String image_path3=image_path_2+"extractedimage.jpg";
                OutputStream outputStream= null;
                try {
                    outputStream = new FileOutputStream(image_path3);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                outputStream.write(image_data);

                System.out.println("Image Found");
            }
            else {
                System.out.println("Image Not Found");
            }

            conn.close();
            System.out.println("Connection closed... SUCE$$FullY");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
