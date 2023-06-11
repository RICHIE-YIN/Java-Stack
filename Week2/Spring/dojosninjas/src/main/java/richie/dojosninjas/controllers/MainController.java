package richie.dojosninjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import richie.dojosninjas.models.Dojo;
import richie.dojosninjas.models.Ninja;
import richie.dojosninjas.services.DojoService;
import richie.dojosninjas.services.NinjaService;


@Controller
public class MainController {

    @Autowired DojoService dojoService;
    @Autowired NinjaService ninjaService;
    
    @GetMapping("/dojos/new")
    public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
        return "dojos/index.jsp";
    }
    
    @PostMapping("/dojos")
    public String createDojo(@ModelAttribute("dojo") Dojo dojo) {
        dojoService.createDojo(dojo);
        return "redirect:/";

    }
    @GetMapping("/ninjas/new")
    public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
        List<Dojo> dojos = dojoService.getAllDojos(); //doing this brings all dojos to create a ninja screen
        System.out.println(dojos);
        model.addAttribute("dojos", dojos); // allows us to display from backend to frontend
        return "ninjas/index.jsp";
    }
    
    @PostMapping("/ninjas")
    public String createNinja(@ModelAttribute("ninja") Ninja ninja) {
        ninjaService.createNinja(ninja);
        return "redirect:/";
    }

    @GetMapping("/dojos/{id}")
    public String dojoInfo(@PathVariable("id") Long id, Model model) {
        Dojo dojo = dojoService.getOneDojo(id);
        model.addAttribute("dojo", dojo);
        return "dojos/show.jsp";
    }
    // List<Dojo> dojos = dojoService.getAllDojos();
}
