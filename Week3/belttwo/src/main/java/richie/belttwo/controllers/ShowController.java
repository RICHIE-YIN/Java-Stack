package richie.belttwo.controllers;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import richie.belttwo.models.Rating;
import richie.belttwo.models.Show;
import richie.belttwo.models.User;
import richie.belttwo.services.RatingService;
import richie.belttwo.services.ShowService;
import richie.belttwo.services.UserService;

@Controller
public class ShowController {

    @Autowired
    ShowService showService;

    @Autowired
    UserService userService;

    @Autowired
    RatingService ratingService;

    // get for home
    @GetMapping("/shows")
    public String home(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/logout";
        }
        User user = userService.getOneUser(userId);
        List<Show> shows = showService.getAllShows();
        model.addAttribute("user", user);
        model.addAttribute("shows", shows);
        return "shows/index.jsp";
    }

    // get for create
    @GetMapping("/shows/new")
    public String addShow(@ModelAttribute("show") Show show, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }
        
        User user = userService.getOneUser(userId);
        // model.addAttribute("show", new Show());
        // model.addAttribute("user", user);
        return "shows/newShow.jsp";
    }

    // create
    @PostMapping("/show/new")
    public String addShow(@Valid Show show, BindingResult result, HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId"); // checks if user is logged in/in session
        if (userId == null) {
            return "redirect:/shows/new";
        }
    
        User user = userService.getOneUser(userId); //passes id and validates that user isnt null
        if (user == null) {
            return "redirect:/shows/new";
        }
    
        if (result.hasErrors()) { //validation errors from users and shows
            model.addAttribute("user", user);
            model.addAttribute("show", show);
            return "shows/newShow.jsp";
        }
    
        if(showService.titleExists(show.getTitle())) {
            result.rejectValue("title", "titleExists", "Title must be unique!!!");
            model.addAttribute("user", user);
            model.addAttribute("show", show);
            return "redirect:/shows/edit";
        }
    
        show.setUser(user); //sets user to show
        showService.createShow(show); //creates show
    
        // Create a new rating object for the newly created show
        Rating rating = new Rating();
        rating.setShow(show);
        rating.setUser(user);
        ratingService.createRating(rating);
    
        return "redirect:/shows";
    }
    
    

    //get one for show
    @GetMapping("/shows/{id}")
    public String viewOne(@PathVariable("id") Long id, Model model, HttpSession session) {
        User currentUser = (User) session.getAttribute("user"); //checks if User is the one who created
        if (currentUser == null) {
            return "redirect:/";
        }
            
        Show show = showService.getOneShow(id); //get one show id
        model.addAttribute("show", show);
        
        boolean canEdit = currentUser.getId().equals(show.getUser().getId()); //checks if user in session and show user id matches
        model.addAttribute("canEdit", canEdit);
        
        return "shows/getOne.jsp";
    }

    // //ratings
    // @PostMapping("shows/{id}")
    // public String rateShow(@RequestParam("rating") Integer rating, @PathVariable("id") Long id, HttpSession session) {
    //     Show show = showService.getOneShow(id);
    //     User currentUser = (User) session.getAttribute("user");
    //     if(currentUser == null) {
    //         return "redirect:/";
    //     }
    //     show.getRaters().add(currentUser);
    //     show.setRatings(show.getRatings() + rating);
    //     showService.updateShow(show);
    //     return "redirect:/shows/" + id ;
    // }

    //edit
    @GetMapping("/shows/{id}/edit")
    public String editShow(@PathVariable("id") Long id, Model model, HttpSession session) {
    User currentUser = (User) session.getAttribute("user");
    if (currentUser == null) {
        return "redirect:/";
    }

    Show show = showService.getOneShow(id);
    boolean isCurrentUser = currentUser.getId().equals(show.getUser().getId());

    model.addAttribute("show", show);
    model.addAttribute("user", currentUser);
    model.addAttribute("isCurrentUser", isCurrentUser);

    return "shows/editShow.jsp";
    }

@PostMapping("/show/{id}/editshow")
    public String updateShow(@PathVariable("id") Long id, @Valid @ModelAttribute("show") Show show, BindingResult result, HttpSession session, Model model) {
        if(result.hasErrors()) {
            return "shows/editShow.jsp";
        }

        if(showService.titleExists(show.getTitle())) {
            result.rejectValue("title", "titleExists", "Title must be unique!!!");
            return "redirect:/shows/" + show.getId() + "/edit";
        }

        User currentUser = (User) session.getAttribute("user");
        if(currentUser == null) {
            return "redirect:/";
        }

        Show existingShow = showService.getOneShow(id);
        if(!currentUser.getId().equals(existingShow.getUser().getId())) {
            return "redirect:/";
        }

        show.setId(id);
        show.setUser(currentUser);
        showService.updateShow(show);
        return "redirect:/shows/" + id;
    }

    // delete
    @DeleteMapping("/show/{id}/delete")
    public String deleteShow(@PathVariable("id") Long id) {
        showService.deleteShowById(id);
        return "redirect:/shows";
    }
}
