package orders_and_items;

import java.util.ArrayList;
public class TestOrders {
    /**
     * @param args
     */
    public static void main(String[] args) {
    
        Order order1 = new Order();
        order1.addItem(new Item ("mocha", 3.99));
        order1.addItem(new Item ("cappucino", 5.49));
        
        Order order2 = new Order();
        order2.addItem(new Item ("latte", 4.49));
        order2.addItem(new Item ("mocha", 3.99));
        
        Order order3 = new Order("Richie");
        order3.addItem(new Item ("latte", 4.49));
        order3.addItem(new Item ("cappucino", 5.49));
        
        Order order4 = new Order("Ricky");
        order4.addItem(new Item ("mocha", 3.99));
        order4.addItem(new Item ("cappucino", 5.49));
        
        Order order5 = new Order("Kayla");
        order5.addItem(new Item ("mocha", 3.99));
        order5.addItem(new Item ("latte", 4.49));
        
        // order2.setReady(true);
        // System.out.println(order2.getStatusMessage());
        // System.out.println(order1.getOrderTotal());
        order3.display();
    }
}
    //     // Menu items
    //         Item item1 = new Item();
    //         item1.name = "mocha" ;
    //         item1.price = 5.99;

    //         Item item2 = new Item();
    //         item2.name = "latte" ;
    //         item2.price = 5.49;

    //         Item item3 = new Item();
    //         item3.name = "drip coffee" ;
    //         item3.price = 4.49;

    //         Item item4 = new Item();
    //         item4.name = "cappuchino" ;
    //         item4.price = 5.49;

    //     // Order variables -- order1, order2 etc.
    //         Order order1 = new Order();
    //         order1.name = "Cindhun";
    //         order1.total = item1.price;
    //         order1.ready = true;
    //         order1.items = new ArrayList<Item>();
    //         order1.items.add(item1);
            
    //         Order order2 = new Order();
    //         order2.name = "Jimmy";
    //         order2.total = item1.price;
    //         order2.ready = true;
    //         order2.items = new ArrayList<Item>();
    //         order2.items.add(item1);
            
    //         Order order3 = new Order();
    //         order3.name = "Noah";
    //         order3.total = item4.price;
    //         order3.ready = true;
    //         order3.items = new ArrayList<Item>();
    //         order3.items.add(item4);

    //         Order order4 = new Order();
    //         order4.name = "Sam";
    //         order4.total = item2.price;
    //         order4.ready = true;
    //         order4.items = new ArrayList<Item>();
    //         order4.items.add(item2);
    //         order4.items.add(item2);
    //         order4.items.add(item2);

    //     // Application Simulations
    //     // Use this example code to test various orders' updates
    //     System.out.printf("Name: %s\n", order1.name);
    //     System.out.printf("Total: %s\n", order1.total);
    //     System.out.printf("Ready: %s\n", order1.ready);
    //     System.out.printf("items: ");
    //     for (Item item : order1.items) {
    //         System.out.printf("%s ", item.name);
    //     }

    //     System.out.printf("Name: %s\n", order2.name);
    //     System.out.printf("Total: %s\n", order2.total);
    //     System.out.printf("Ready: %s\n", order2.ready);
    //     System.out.printf("items: ");
    //     for (Item item : order2.items) {
    //         System.out.printf("%s ", item.name);
    //     }

    //     System.out.printf("Name: %s\n", order3.name);
    //     System.out.printf("Total: %s\n", order3.total);
    //     System.out.printf("Ready: %s\n", order3.ready);
    //     System.out.printf("items: ");
    //     for (Item item : order3.items) {
    //         System.out.printf("%s ", item.name);
    //     }

    //     System.out.printf("Name: %s\n", order4.name);
    //     System.out.printf("Total: %s\n", order4.total);
    //     System.out.printf("Ready: %s\n", order4.ready);
    //     System.out.printf("items: ");
    //     for (Item item : order4.items) {
    //         System.out.printf("%s, ", item.name);
    //     }
    // }