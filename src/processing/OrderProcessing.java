package processing;

import java.io.*;

public class OrderProcessing {

    // Method to save an order to a file
    public static void saveOrder() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("orders.txt", true))) {
            writer.write("Sample Order: Pasta, Chicken Curry\n");
            System.out.println("Order saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving order: " + e.getMessage());
        }
    }

    // Method to read all orders from the file
    public static void readOrders() {
        try (BufferedReader reader = new BufferedReader(new FileReader("orders.txt"))) {
            String line;
            System.out.println("Existing Orders:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No orders found.");
        } catch (IOException e) {
            System.out.println("Error reading orders: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        saveOrder();    // Save a new order
        readOrders();   // Read all orders
    }
}
