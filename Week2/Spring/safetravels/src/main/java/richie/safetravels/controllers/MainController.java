package richie.safetravels.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import richie.safetravels.models.Expense;
import richie.safetravels.services.ExpenseService;

@Controller
public class MainController {

    @Autowired ExpenseService expenseService; //connects book repository. BookRepository is class/object, bookRepository is the instance of that object of which you can call on and grab from DB
    
        // !CREATE
        // @GetMapping("/expenses/new")
        // public String newExpense(@ModelAttribute("expense") Expense expense) { //creates new expense as soon as link is pressed
        //     return "expenses/new.jsp";
        // }
    
        @PostMapping("/newexpenses")
        public String createExpense(@ModelAttribute("newExpense") Expense expense)
            {
            expenseService.createExpense(expense);
            return "redirect:/expenses";
        }
    
    
        //! READ ALL
        @GetMapping("/expenses")
        public String index(Model model){ //Model model allows us to get stuff front the backend to the backend
            List<Expense> expenses = expenseService.getAllExpenses(); //we created a method called getAllExpenses. in ExpenseService, we actuallu implement the getall method by the expenseRepository 
            // System.out.println(expenses); //in terminal it shows the list of expenses in your db
            model.addAttribute("expenses", expenses); //sends expenses down to models
            model.addAttribute("newExpense", new Expense());
            return "expenses/index.jsp";
        }
    
        // !READ ONE
        @GetMapping("/expenses/{id}")
            public String show(@PathVariable("id") Long id, Model model) { //allows you to access whatever is typed into that route
                Expense expense = expenseService.getOneExpense(id); //calls the method from ExpenseService
                model.addAttribute("expense", expense);
                // System.out.println(id); //print out id
                // System.out.println(expense); //print out expense
                return "expenses/show.jsp";
        }
    
        // !UPDATE
        @GetMapping("/expenses/{id}/edit")
            public String edit(@PathVariable("id") Long id, Model model) {
            Expense expense = expenseService.getOneExpense(id);
            model.addAttribute("expense", expense);
            return "expenses/edit.jsp";
    }
    
        @PutMapping("/expenses/{id}")
        public String updateExpense(@ModelAttribute("expense") Expense expense) {
            expenseService.updateExpense(expense);
            return "redirect:/expenses";
        }
    
        // !DELETE
        @DeleteMapping("/expenses/{id}")
        public String deleteExpense(@PathVariable("id") Long id) {
            Expense expense = expenseService.getOneExpense(id);
            expenseService.deleteExpense(expense);
            return "redirect:/expenses";
        }
}
