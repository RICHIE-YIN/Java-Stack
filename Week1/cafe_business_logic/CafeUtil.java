package cafe_business_logic;

import java.util.ArrayList;

public class CafeUtil {
    
    // this code is for 10 weeks
    // public int getStreakGoal(){
    //     int sum = 0;
    //     for(int i = 0; i <= 10; i++) {
    //         sum += i;
    //     }
    //     return sum;
    // }

    // this code allows you to choose any amount of weeks you want to go for
    public int getStreakGoal(int numWeeks){
        int sum = 0;
        for(int i = 0; i <= numWeeks; i++) {
            sum += i;
        }
        return sum;
    };

    public double getOrderTotal(double[] prices){ //prices is just a varialbe declared. you can call it anything
        double total = 0;
        for(int i = 0; i < prices.length; i++) {
            total += prices[i]; // we put i inside the square brackets to target the array
        }
    return total;
    }

    public void displayMenu(ArrayList<String> menuItems) {
        //use Alt + Shift + O to import something you dont have. in this case ArrayList.
        for(int i = 0; i < menuItems.size(); i++) { //we use .size insted of .length because this is a dynamic list
            System.out.println(i + " " + menuItems.get(i)); //the i + "" + menuItems is so it shows the item's plce in the array
        } 
    }

    public void addCustomer(ArrayList<String> customers) { //add void to public if there's nothing that you need to return
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.println("Hello, " + userName);
        System.out.printf("There are %d customers ahead of you", customers.size());
        customers.add(userName);
        System.out.println(customers);
    }



}
