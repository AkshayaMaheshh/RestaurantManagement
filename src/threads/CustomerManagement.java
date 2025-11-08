package threads;

import java.util.*;
import java.util.concurrent.*;

class Customer implements Runnable {
    private String name;

    public Customer(String name) { this.name = name; }

    @Override
    public void run() {
        System.out.println(name + " is placing an order...");
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        System.out.println(name + " order completed!");
    }
}

public class CustomerManagement {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(new Customer("Alice"));
        service.execute(new Customer("Bob"));
        service.shutdown();
        service.awaitTermination(5, TimeUnit.SECONDS);
    }
}
