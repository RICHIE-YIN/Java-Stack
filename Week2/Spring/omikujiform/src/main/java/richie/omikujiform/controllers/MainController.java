package richie.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

    //! READ ALL
    @GetMapping("/omijuki")
    public String index(){
        return "index.jsp";
    }

    @GetMapping("/omijuki/show")
    public String show(){
        return "show.jsp";
    }

    @PostMapping("/routetohandleformdata")
    public String handledata(
        @RequestParam(value = "number") Integer number,
        @RequestParam(value = "nameofcity") String nameofcity,
        @RequestParam(value = "nameofperson") String nameofperson,
        @RequestParam(value = "activity") String activity,
        @RequestParam(value = "livingthing") String livingthing,
        @RequestParam(value = "somethingnice") String somethingnice,
        HttpSession session
    ) {
        session.setAttribute("number", number);
        session.setAttribute("nameofcity", nameofcity);
        session.setAttribute("nameofperson", nameofperson);
        session.setAttribute("activity", activity);
        session.setAttribute("livingthing", livingthing);
        session.setAttribute("somethingnice", somethingnice);
        System.out.println(number);
        return "redirect:/show";
    }

}