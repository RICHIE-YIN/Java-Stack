package richie.belt3.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import richie.belt3.models.Student;
import richie.belt3.models.YogaClass;
import richie.belt3.services.StudentService;
import richie.belt3.services.YogaClassService;

@Controller
public class StudentController {
    
    @Autowired
    private StudentService studentService;
    
    @Autowired
    private YogaClassService yogaClassService;

    // @GetMapping("/student/new")
    
    // public String newStudentForm(Model model) {
    //     model.addAttribute("student", new Student());
    //     return "student/newStudent.jsp";
    // }

    
    @PostMapping("/student/new")
    public String createStudent(@Valid Student student, YogaClass yogaClass, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("student", student);
            return "student/newStudent.jsp";
        }
        studentService.createStudent(student);
        return "redirect:/classes";
    }
    
    @GetMapping("/yogaclass/{id}/assign")
    public String assignStudentForm(@PathVariable("id") Long classId, Model model) {
        YogaClass yogaClass = yogaClassService.getOneYogaClass(classId);
        List<Student> allStudents = studentService.getAllStudents();
        model.addAttribute("yogaClass", yogaClass);
        model.addAttribute("allStudents", allStudents);
        return "redirect:/classes/";
    }    
    
    @PostMapping("/yogaclass/{id}/assign")
    public String assignStudent(@PathVariable("id") Long id, @ModelAttribute("student") Student student) {
        YogaClass yogaClass = yogaClassService.getOneYogaClass(id);
        System.out.println(student);
        yogaClass.getStudents().add(student);
        yogaClassService.updateYogaClass(yogaClass);
        return "redirect:/classes";
    }
    
}