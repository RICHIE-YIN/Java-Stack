package richie.belt3.controllers;

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

import richie.belt3.models.Student;
import richie.belt3.models.User;
import richie.belt3.models.YogaClass;
import richie.belt3.services.StudentService;
import richie.belt3.services.UserService;
import richie.belt3.services.YogaClassService;

@Controller
public class YogaClassController {

    @Autowired
    YogaClassService yogaClassService;

    @Autowired
    UserService userService;

    @Autowired
    StudentService studentService;

    // get for home
    @GetMapping("/classes")
    public String home(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/logout";
        }
        User user = userService.getOneUser(userId);
        List<YogaClass> yogaclass = yogaClassService.getAllYogaClass();
        model.addAttribute("user", user);
        model.addAttribute("yogaclasss", yogaclass);

        // for (YogaClass yogaClass : yogaclass) {
        //     boolean canEdit = user.getId().equals(yogaClass.getUser().getId());
        //     model.addAttribute("canEdit_" + yogaClass.getId(), canEdit);
        // }

        return "yogaclasses/home.jsp";
    }

    // get for create
    @GetMapping("/classes/new")
    public String showYogaClassForm(@ModelAttribute("yogaClass") YogaClass yogaClass, HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }
        User user = userService.getOneUser(userId);
        model.addAttribute("user", user);
        return "yogaclasses/newYogaClass.jsp";
    }
    
    @PostMapping("/yogaclass/new")
    public String createYogaClass(@Valid YogaClass yogaClass, BindingResult result, HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }
        
        User user = userService.getOneUser(userId);
        if (user == null) {
            return "redirect:/";
        }
        
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            model.addAttribute("yogaClass", yogaClass);
            return "yogaclasses/newYogaClass.jsp";
        }
        
        yogaClass.setUser(user);
        yogaClassService.createYogaClass(yogaClass);
        System.out.println(yogaClass);
        return "redirect:/classes/" + yogaClass.getId();
    }
    

    @GetMapping("/classes/{id}")
    public String viewOne(@PathVariable("id") Long id, @ModelAttribute("student") Student student, BindingResult result, Model model, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser == null) {
            return "redirect:/";
        }
    
        YogaClass yogaClass = yogaClassService.getOneYogaClass(id);
        model.addAttribute("yogaClass", yogaClass);
    
        boolean canEdit = currentUser.getId().equals(yogaClass.getUser().getId());
        model.addAttribute("canEdit", canEdit);
    
        List<Student> allStudents = studentService.getAllStudents();
        model.addAttribute("allStudents", allStudents);
    
        model.addAttribute("student", new Student());
    
        return "yogaclasses/viewOne.jsp";
    }
    

    //edit
    @GetMapping("/classes/{id}/edit")
    public String editYogaClass(@PathVariable("id") Long id, Model model, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser == null) {
            return "redirect:/";
        }
        
        YogaClass yogaClass = yogaClassService.getOneYogaClass(id);
        boolean isCurrentUser = currentUser.getId().equals(yogaClass.getUser().getId());
        
        model.addAttribute("yogaClass", yogaClass);
        model.addAttribute("user", currentUser);
        model.addAttribute("isCurrentUser", isCurrentUser);
        
        return "yogaclasses/edit.jsp";
    }
    

    @PostMapping("/yogaclass/{id}/edityogaclass")
    public String updateYogaClass(@PathVariable("id") Long id, @Valid @ModelAttribute("yogaClass") YogaClass yogaClass, BindingResult result, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser == null) {
        return "redirect:/";
        }
        YogaClass existingYogaClass = yogaClassService.getOneYogaClass(id);
        existingYogaClass.setName(yogaClass.getName());
        existingYogaClass.setDayOfWeek(yogaClass.getDayOfWeek());
        existingYogaClass.setPrice(yogaClass.getPrice());
        existingYogaClass.setTime(yogaClass.getTime());
        existingYogaClass.setDescription(yogaClass.getDescription());

        if (result.hasErrors()) {
            return "yogaclass/edit.jsp";
        } else {
            yogaClassService.updateYogaClass(existingYogaClass);
            return "redirect:/classes";
        }
    }


    // delete
    @DeleteMapping("/yogaclass/{id}/delete")
    public String deleteYogaClass(@PathVariable("id") Long id) {
        yogaClassService.deleteYogaClassById(id);
        return "redirect:/classes";
    }
    
    
}
