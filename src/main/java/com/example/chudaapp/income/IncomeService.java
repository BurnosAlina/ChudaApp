package com.example.chudaapp.income;

import com.example.chudaapp.expenses.Expense;
import com.example.chudaapp.expenses.ExpenseDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class IncomeService {

    private IncomeRepository incomeRepository;
    private IncomeMapper incomeMapper;

    public IncomeService(IncomeRepository incomeRepository, IncomeMapper incomeMapper) {
        this.incomeRepository = incomeRepository;
        this.incomeMapper = incomeMapper;
    }

    public List<IncomeDto> findAll() {
        List<Income> incomes = incomeRepository.findAll();
        List<IncomeDto> incomesDto = new ArrayList<>();
        for (Income income : incomes) {
            IncomeDto incomeDto = incomeMapper.convertToDto(income);
            incomesDto.add(incomeDto);
        }
        return incomesDto;
    }

    @Transactional
    public void save (IncomeDto incomeDto){
        Income income = incomeMapper.convertFromDto(incomeDto);
        incomeRepository.save(income);
    }

    public BigDecimal incomesInTotal (){
        BigDecimal inTotal = incomeRepository.calculateTotalAmount();
        return inTotal.setScale(2);
    }

    public void delete (){
        incomeRepository.deleteAll();
    }
}
