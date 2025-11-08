package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RestaurantGUI {

    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/restaurantdb";
    private static final String USER = "root";
    private static final String PASSWORD = "$tri@V3r";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Restaurant Order Management System");
            frame.setSize(550, 450);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            JLabel label = new JLabel("Select your dish:");
            String[] items = {"Pizza", "Pasta", "Burger", "Sandwich", "Chicken Curry", "Noodles"};
            JComboBox<String> menu = new JComboBox<>(items);

            JTextArea output = new JTextArea(12, 40);
            output.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(output);

            JButton orderButton = new JButton("Place Order");
            JButton viewButton = new JButton("View Orders");

            // Action for placing a new order
            orderButton.addActionListener(e -> {
                String customerName = JOptionPane.showInputDialog(frame, "Enter your name:");
                if (customerName == null || customerName.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Name cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String item = (String) menu.getSelectedItem();
                double price = getPrice(item);

                saveOrderToDatabase(customerName, item, price);
                output.append("Order placed successfully!\nCustomer: " + customerName +
                        "\nItem: " + item + "\nPrice: ₹" + price + "\n\n");
            });

            // Action for viewing all orders from database
            viewButton.addActionListener(e -> {
                output.setText(fetchOrdersFromDatabase());
            });

            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout());
            panel.add(label);
            panel.add(menu);
            panel.add(orderButton);
            panel.add(viewButton);
            panel.add(scrollPane);

            frame.add(panel);
            frame.setVisible(true);
        });
    }

    // Fetch all orders from MySQL
    private static String fetchOrdersFromDatabase() {
        StringBuilder orders = new StringBuilder();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM orders ORDER BY id DESC");

            orders.append("---- All Orders ----\n");
            while (rs.next()) {
                orders.append("ID: ").append(rs.getInt("id")).append("\n");
                orders.append("Customer: ").append(rs.getString("customer_name")).append("\n");
                orders.append("Order: ").append(rs.getString("order_details")).append("\n");
                orders.append("Total: ₹").append(rs.getDouble("total_price")).append("\n");
                orders.append("Time: ").append(rs.getTimestamp("order_time")).append("\n");
                orders.append("--------------------\n");
            }
        } catch (SQLException e) {
            orders.append("Database Error: ").append(e.getMessage());
        }
        return orders.toString();
    }

    // Save a new order into MySQL
    private static void saveOrderToDatabase(String customer, String orderDetails, double price) {
        String query = "INSERT INTO orders (customer_name, order_details, total_price) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, customer);
            ps.setString(2, orderDetails);
            ps.setDouble(3, price);
            ps.executeUpdate();

            System.out.println("[Database] Order saved: " + orderDetails + " by " + customer);
        } catch (SQLException e) {
            System.out.println("[Database Error] " + e.getMessage());
        }
    }

    // Assigns simple prices to menu items
    private static double getPrice(String item) {
        switch (item) {
            case "Pizza": return 420.00;
            case "Pasta": return 350.00;
            case "Burger": return 250.00;
            case "Sandwich": return 180.00;
            case "Chicken Curry": return 480.00;
            case "Noodles": return 300.00;
            default: return 200.00;
        }
    }
}
