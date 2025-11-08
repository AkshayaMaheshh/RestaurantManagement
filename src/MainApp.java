// MainApp.java
import menu.MenuManagement;
import processing.OrderProcessing;
import threads.CustomerManagement;
import network.RestaurantServer;
import gui.RestaurantGUI;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("=== RESTAURANT MANAGEMENT SYSTEM ===");

        // Run individual modules (simulating each unit)
        System.out.println("\n--- UNIT I: OOP MODULE ---");
        new MenuManagement(); // Menu Management

        System.out.println("\n--- UNIT II: EXCEPTION & STREAM MODULE ---");
        new OrderProcessing(); // Order Processing

        System.out.println("\n--- UNIT III: MULTITHREADING MODULE ---");
        new CustomerManagement(); // Customer Management

        System.out.println("\n--- UNIT IV: NETWORKING MODULE ---");
        RestaurantServer server = new RestaurantServer();
        server.runServer();
        server.runClient();

        System.out.println("\n--- UNIT V: GUI MODULE ---");
        RestaurantGUI gui = new RestaurantGUI();
        gui.main(null); // Launch GUI window
    }
}
