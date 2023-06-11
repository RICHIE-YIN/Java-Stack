package richie.fruityloops.models;

//pojo model is a representation of the data that's going to be stored in our database

public class Item {
    // MEMBER VARIABLES
    private String name;
    private double price;


    public Item() {
    }

    // CONSTRUCTOR
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    // As always, don't forget to generate Getters and Setters!
}



// public class Item {
//     private String itemName;
//     private double price;
//     private String description;
//     private String vendor;


//     public Item() {
//     }


//     public Item(String itemName, double price, String description, String vendor) {
//         this.itemName = itemName;
//         this.price = price;
//         this.description = description;
//         this.vendor = vendor;
//     }


//     public String getItemName() {
//         return this.itemName;
//     }

//     public void setItemName(String itemName) {
//         this.itemName = itemName;
//     }

//     public double getPrice() {
//         return this.price;
//     }

//     public void setPrice(double price) {
//         this.price = price;
//     }

//     public String getDescription() {
//         return this.description;
//     }

//     public void setDescription(String description) {
//         this.description = description;
//     }

//     public String getVendor() {
//         return this.vendor;
//     }

//     public void setVendor(String vendor) {
//         this.vendor = vendor;
//     }

// }
