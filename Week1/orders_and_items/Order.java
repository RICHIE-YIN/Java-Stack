package orders_and_items;

import java.util.ArrayList;

// public class Order {
//     String name;
//     double total;
//     boolean ready;
//     ArrayList<Item> items;
// }



// Here we're creating a new data type called Order
public class Order {
    
    // MEMBER VARIABLES
    private String name; // default value of null
    private boolean ready; // default value false
    private ArrayList<Item> items; // defaults to null
    
    // CONSTRUCTOR
    // No arguments, sets name to "Guest", initializes items as an empty list.
    public Order () {
        this.name = "Guest";
        this.ready = false;
        this.items = new ArrayList<Item>();
    }
    
    // OVERLOADED CONSTRUCTOR
    // Takes a name as an argument, sets name to this custom name.
    // Initializes items as an empty list.
    public Order(String name) {
        this.name = name;
        this.ready = false;
        this.items = new ArrayList<Item>();
    }
    
    // ORDER METHODS
    
    	// Most of your code will go here, 
    	// so implement the getters and setters first!
    
    // GETTERS & SETTERS
    public void addItem(Item item) {
        items.add(item);
    }

    public String getStatusMessage() {
        if (ready == true) {
            return "Your order is ready.";
        }
        else {
            return "Thank you for waiting. Your order will be ready soon";
        }
    }

    public double getOrderTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }


    public void setReady(boolean ready) {
        this.ready = true;
    }

    public void display() {
        System.out.printf("Customer name %s \n", name);
        System.out.println("Items:");
        for (Item item : items) {
            System.out.printf("%s - %s, ", item.getName(), item.getPrice() );
        }
        System.out.printf("\n Total - %s", getOrderTotal());
    }
}