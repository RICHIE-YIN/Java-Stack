package richie.booksapi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {
    @GetMapping("/register")
    public String register() {
        return "users/index.jsp";
    }
}
