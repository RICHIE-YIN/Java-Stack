package richie.safetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import richie.safetravels.models.Expense;
import richie.safetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
    @Autowired ExpenseRepository expenseRepository;

	public List<Expense> getAllExpenses() {
		return expenseRepository.findAll();
	}

    public Expense getOneExpense(Long id) {
        Optional<Expense> optionalexpense = expenseRepository.findById(id); //"Optional" because we're searching for something that may or may not be there
        Expense expense = optionalexpense.orElse(null); //if we find the expense, return the expense; if not return null
    return expense;
    }

    public void createExpense(Expense expense) {
        expenseRepository.save(expense);
    }

    public void updateExpense(Expense expense) {
        expenseRepository.save(expense);
    }
    

    public void deleteExpense(Expense expense) {
        expenseRepository.delete(expense);
    }
    
}
