package com.example.chudaapp.income;

import com.example.chudaapp.expenses.Expense;
import com.example.chudaapp.expenses.ExpenseDto;
import org.springframework.stereotype.Component;

@Component
public class IncomeMapper {

    public IncomeDto convertToDto (Income income){
        return new IncomeDto(income.getId(), income.getDate(), income.getDescription(), income.getAmount());
    }

    public Income convertFromDto (IncomeDto dto){
        return new Income(dto.getDate(), dto.getDescription(), dto.getAmount());
    }
}
