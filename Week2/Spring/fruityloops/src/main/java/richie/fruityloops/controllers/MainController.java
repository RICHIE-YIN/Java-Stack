package richie.fruityloops.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import richie.fruityloops.models.Item;

@Controller
public class MainController {
    
    @GetMapping("/")
    public String index(Model model) {
        
        //old method
        // String name = "Grace Hopper";
        // String itemName = "Copper wire";
        // double price = 5.25;
        // String description = "Metal strips, also an illustration of nanoseconds.";
        // String vendor = "Little Things Corner Store";
    
    	// // Your code here! Add values to the view model to be rendered
    
        // model.addAttribute("name", name);
        // model.addAttribute("itemName", itemName);
        // model.addAttribute("price", price);
        // model.addAttribute("description", description);
        // model.addAttribute("vendor", vendor);
        
        //new method
        ArrayList<Item> fruits = new ArrayList<Item>();
        fruits.add(new Item("Kiwi", 1.5));
        fruits.add(new Item("Mango", 2.0));
        fruits.add(new Item("Goji Berries", 4.0));
        fruits.add(new Item("Guava", .75));
        model.addAttribute("fruits", fruits);
        return "index.jsp";
    }


}
