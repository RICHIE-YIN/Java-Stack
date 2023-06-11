package richie.safetravels.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import richie.safetravels.models.Expense;
import richie.safetravels.repositories.ExpenseRepository;

@RestController
public class ExpenseApi {
        //takes all functionality from ExpenseRepository interface and injecting it into methods below.
    // also same thing as @Autowired in MainController
    private final ExpenseRepository expenseRepository;
    public ExpenseApi(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }
    
    @RequestMapping(value="/api/expenses", method=RequestMethod.GET)
    public List<Expense> allExpenses() {
        List<Expense> expenses = expenseRepository.findAll(); //queries db for list of expenses
        return expenses; //all you need to do for an API is just return expenses
    }
}
