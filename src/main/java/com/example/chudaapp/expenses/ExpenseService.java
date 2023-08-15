package com.example.chudaapp.expenses;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {

    private ExpenseRepository expenseRepository;

    private ExpenseMapper expenseMapper;

    public ExpenseService(ExpenseRepository expenseRepository, ExpenseMapper expenseMapper) {
        this.expenseRepository = expenseRepository;
        this.expenseMapper = expenseMapper;
    }

    public List<ExpenseDto> findAll() {
        List<Expense> expenses = expenseRepository.findAll();
        List<ExpenseDto> expensesDto = new ArrayList<>();
        for (Expense expense : expenses) {
            ExpenseDto expenseDto = expenseMapper.convertToDto(expense);
            expensesDto.add(expenseDto);
        }
        return expensesDto;
    }

    public BigDecimal expensesInTotal (){
        BigDecimal inTotal = expenseRepository.calculateTotalAmount();
        return inTotal.setScale(2);
    }

    @Transactional
    public void save (ExpenseDto expenseDto){
        Expense expense = expenseMapper.convertFromDto(expenseDto);
        expenseRepository.save(expense);
    }

    public void delete (){
        expenseRepository.deleteAll();
    }
}
