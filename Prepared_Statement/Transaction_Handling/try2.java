package JDBC.Prepared_Statement.Transaction_Handling;

import java.sql.*;

public class try2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "root";
        String password = "ashish";
        String driver = "com.mysql.cj.jdbc.Driver";
        String withdrawQuery = "UPDATE accounts SET balance = balance - ? WHERE account_number = ?";
        String depositQuery = "UPDATE accounts SET balance = balance + ? WHERE account_number = ?";

        try {
            Class.forName(driver);
            System.out.println("Driver loaded successfully.");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found: " + e.getMessage());
            return;
        }

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to database");
            conn.setAutoCommit(false);

            try (PreparedStatement withdrawStatement = conn.prepareStatement(withdrawQuery);
                 PreparedStatement depositStatement = conn.prepareStatement(depositQuery)) {

                withdrawStatement.setDouble(1, 500);
                withdrawStatement.setString(2, "account123");

                depositStatement.setDouble(1, 500);
                depositStatement.setString(2, "account456");

                withdrawStatement.executeUpdate();
                depositStatement.executeUpdate();

                conn.commit();
                System.out.println("Transaction Successful");

            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Transaction Failed: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }
}