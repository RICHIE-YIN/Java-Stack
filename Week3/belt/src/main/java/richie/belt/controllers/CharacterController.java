package richie.belt.controllers;

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

import richie.belt.models.Character;
import richie.belt.models.User;
import richie.belt.services.CharacterService;
import richie.belt.services.UserService;

@Controller
public class CharacterController {

    @Autowired
    CharacterService characterService;

    @Autowired
    UserService userService;

    // get for home
    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/logout";
        }
        User user = userService.getOneUser(userId);
        List<Character> characters = characterService.getAllCharacters();
        model.addAttribute("user", user);
        model.addAttribute("characters", characters);
        return "character/home.jsp";
    }

    // get for create
    @GetMapping("/names/new")
    public String addCharacter(@ModelAttribute("character") Character character, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }
        User user = userService.getOneUser(userId);
        // model.addAttribute("character", new Character());
        // model.addAttribute("user", user);
        return "character/newCharacter.jsp";
    }

    // create
    @PostMapping("/character/new")
    public String addCharacter(@Valid Character character, BindingResult result, HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId"); // checks if user is logged in/in session
        if (userId == null) {
            return "redirect:/names/new";
        }
        
        User user = userService.getOneUser(userId); //passes id and validates that user isnt null
        if (user == null) {
            return "redirect:/names/new";
        }
        
        if (result.hasErrors()) { //validation errors from users and characters
            model.addAttribute("user", user);
            model.addAttribute("character", character);
            return "character/newCharacter.jsp";
        }
        
        if (characterService.nameExists(character.getName())) { //checks if name is unique
            result.rejectValue("name", "error.character", "A character with this name already exists.");
            model.addAttribute("user", user);
            model.addAttribute("character", character);
            return "character/newCharacter.jsp";
        }
        
        character.setUser(user); //sets user to character
        characterService.createCharacter(character); //creates character
        return "redirect:/home";
    }
    

    // upvote
    @PostMapping("/character/upvote/{id}")
    public String upvote(@PathVariable("id") Long id, HttpSession session) {
        User currentUser = (User) session.getAttribute("user"); //gets User
        if (currentUser == null) {
            return "redirect:/";
        }
        Character character = characterService.getOneCharacter(id); //singles out one character
        List<User> upvoters = character.getUpvoters(); //gets a list of upvoters
        if (upvoters.contains(currentUser)) { //another backend validation so that if User already upvoted character they cant do it again
            return "redirect:/home";
        }
    
        Integer upvotes = character.getUpvotes(); //gets the upvote count and sets it to 0 in case its null
        if (upvotes == null) {
            upvotes = 0;
        }
        character.setUpvotes(upvotes + 1); //increments by 1
        upvoters.add(currentUser); //saves in db that user did upvote
        characterService.updateCharacter(character); //updates
    
        return "redirect:/home";
    }
    
    
    //get one for name
    @GetMapping("/character/{id}")
    public String viewOne(@PathVariable("id") Long id, Model model, HttpSession session) {
        User currentUser = (User) session.getAttribute("user"); //checks if User is the one who created
        if (currentUser == null) {
            return "redirect:/";
        }
            
        Character character = characterService.getOneCharacter(id); //get one character id
        model.addAttribute("character", character);
        
        boolean hasUpvoted = characterService.hasUserUpvotedCharacter(currentUser, character); //checks if user has upvoted or not
        model.addAttribute("hasUpvoted", hasUpvoted);
    
        boolean canEdit = currentUser.getId().equals(character.getUser().getId()); //checks if user in session and character user id matches
        model.addAttribute("canEdit", canEdit);
        
        return "character/viewOne.jsp";
    }

    //edit
    @GetMapping("/character/{id}/edit")
    public String editCharacter(@PathVariable("id") Long id, Model model, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser == null) {
            return "redirect:/";
        }
        
        Character character = characterService.getOneCharacter(id);
        boolean isCurrentUser = currentUser.getId().equals(character.getUser().getId());
        
        model.addAttribute("character", character);
        model.addAttribute("user", currentUser);
        model.addAttribute("isCurrentUser", isCurrentUser);
        
        return "character/edit.jsp";
    }
    

@PostMapping("/character/{id}/editcharacter")
    public String updateCharacter(@PathVariable("id") Long id, @Valid @ModelAttribute("character") Character character, BindingResult result, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser == null) {
            return "redirect:/";
        }
        
        Character existingCharacter = characterService.getOneCharacter(id);
        existingCharacter.setGender(character.getGender());
        existingCharacter.setOrigin(character.getOrigin());
        existingCharacter.setMeaning(character.getMeaning());
        
        if (result.hasErrors()) {
            return "character/edit.jsp";
        } else {
            characterService.updateCharacter(existingCharacter);
            return "redirect:/character/" + id;
        }
    }

    // delete
    @DeleteMapping("/character/{id}/delete")
    public String deleteCharacter(@PathVariable("id") Long id) {
        characterService.deleteCharacterById(id);
        return "redirect:/home";
    }
    
    
}
