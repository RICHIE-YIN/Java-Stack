package richie.safetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository; //part of framework

import richie.safetravels.models.Expense; //imported from book MODEL

public interface ExpenseRepository extends CrudRepository<Expense, Long> {
    List<Expense> findAll();
}
