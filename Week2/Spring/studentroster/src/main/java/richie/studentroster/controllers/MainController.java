package richie.studentroster.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import richie.studentroster.models.Dorm;
import richie.studentroster.models.Student;
import richie.studentroster.services.DormService;
import richie.studentroster.services.StudentService;

@Controller
public class MainController {
    
    @Autowired DormService dormService;
    @Autowired StudentService studentService;

    //main landing
    @GetMapping("/dorms")
    public String allDorms(Model model) {
        List<Dorm> dorms = dormService.getAllDorms();
        model.addAttribute("dorms", dorms);
        return "dorms/alldorms.jsp";
    }
    
    //add dorm
    @GetMapping("/dorms/new")
    public String newDorm(@ModelAttribute("dorm") Dorm dorm) {
        return "dorms/index.jsp";
    }
    @PostMapping("/createdorms")
    public String createDorm(@ModelAttribute("dorm") Dorm dorm) {
        dormService.createDorm(dorm);
        return "redirect:/";

    //add students
    }
    @GetMapping("/students/new")
    public String newStudent(@ModelAttribute("student") Student student, Model model) {
        List<Dorm> dorms = dormService.getAllDorms(); //doing this brings all dorms to create a student screen
        System.out.println(dorms);
        model.addAttribute("dorms", dorms); // allows us to display from backend to frontend
        return "students/index.jsp";
    }
    @PostMapping("/createstudents")
    public String createStudent(@ModelAttribute("student") Student student) {
        studentService.createStudent(student);
        return "redirect:/";
    }

    //show dorm/update dorm
    @GetMapping("/dorms/{id}")
    public String dormInfo(@PathVariable("id") Long id, Model model) {
        Dorm dorm = dormService.getOneDorm(id);
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("dorm", dorm);
        model.addAttribute("students", students);
        return "dorms/show.jsp";
    }
    @PostMapping("/dorms/{id}/assignstudent")
    public String assignStudents(@PathVariable("id") Long id, @RequestParam("studentId") Long studentId) {
        Dorm dorm = dormService.getOneDorm(id);
        Student student = studentService.getOneStudent(studentId);
        student.setDorm(dorm);
        studentService.updateStudent(student);
        return "redirect:/dorms/" + id;
    }
    
        // !DELETE
        @DeleteMapping("/students/{id}")
        public String deleteStudent(@PathVariable("id") Long id) {
            Student student = studentService.getOneStudent(id);
            studentService.deleteStudent(student);
            return "redirect:/dorms";
        }
}
