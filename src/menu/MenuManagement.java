package menu;

import java.util.*;


abstract class Dish {
    protected String name;
    protected double price;

    public Dish(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public abstract void showDetails();
}


class VegDish extends Dish {
    public VegDish(String name, double price) {
        super(name, price);
    }

    @Override
    public void showDetails() {
        System.out.println("Veg Dish: " + name + " - $" + price);
    }
}


class NonVegDish extends Dish {
    public NonVegDish(String name, double price) {
        super(name, price);
    }

    @Override
    public void showDetails() {
        System.out.println("Non-Veg Dish: " + name + " - $" + price);
    }
}


class Order<T extends Dish> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public void showOrder() {
        items.forEach(Dish::showDetails);
    }
}


public class MenuManagement {
    public static void main(String[] args) {
        Order<Dish> order = new Order<>();
        order.addItem(new VegDish("Pasta", 150));
        order.addItem(new NonVegDish("Chicken Curry", 250));
        order.showOrder();
    }
}
