package com.example.chudaapp.controllers;

import com.example.chudaapp.income.IncomeDto;
import com.example.chudaapp.income.IncomeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class IncomeController {

    private IncomeService incomeService;

    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @GetMapping("/incomes")
    String incomes (Model model){
        List<IncomeDto> incomes = incomeService.findAll();
        BigDecimal inTotal = incomeService.incomesInTotal();
        model.addAttribute("income", new IncomeDto());
        model.addAttribute("incomes", incomes);
        model.addAttribute("inTotal", inTotal);
        return "incomes";
    }

    @PostMapping("/addIncome")
    String addIncome (@Valid @ModelAttribute("income") IncomeDto incomeDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("income", incomeDto);
            List<IncomeDto> incomes = incomeService.findAll();
            BigDecimal inTotal = incomeService.incomesInTotal();
            model.addAttribute("incomes", incomes);
            model.addAttribute("inTotal", inTotal);
            return "incomes";
        }
        incomeService.save(incomeDto);
        List<IncomeDto> incomes = incomeService.findAll();
        BigDecimal inTotal = incomeService.incomesInTotal();
        model.addAttribute("incomes", incomes);
        model.addAttribute("inTotal", inTotal);
        return "incomes";
    }
}
