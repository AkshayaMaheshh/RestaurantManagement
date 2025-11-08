package network;

import java.sql.*;

public class DatabaseConnection {

    // JDBC connection details
    private static final String URL = "jdbc:mysql://localhost:3306/restaurantdb";
    private static final String USER = "root";
    private static final String PASSWORD = "$tri@V3r";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("[Database] Connected successfully to restaurantdb!");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM orders");

            System.out.println("---- Order List ----");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Customer: " + rs.getString("customer_name"));
                System.out.println("Order: " + rs.getString("order_details"));
                System.out.println("Total Price: ₹" + rs.getDouble("total_price"));
                System.out.println("Date: " + rs.getTimestamp("order_time"));
                System.out.println("--------------------");
            }

            conn.close();
            System.out.println("[Database] Connection closed.");
        } catch (SQLException e) {
            System.out.println("[Database Error] " + e.getMessage());
        }
    }
}
