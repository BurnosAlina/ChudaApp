package com.example.chudaapp.expenses;

import org.springframework.stereotype.Component;

@Component
public class ExpenseMapper {

    public ExpenseDto convertToDto (Expense expense){
        return new ExpenseDto(expense.getId(), expense.getDate(), expense.getDescription(), expense.getAmount());
    }

    public Expense convertFromDto (ExpenseDto dto){
        return new Expense(dto.getDate(), dto.getDescription(), dto.getAmount());
    }
}
