package com.example.chudaapp.controllers;

import com.example.chudaapp.expenses.ExpenseDto;
import com.example.chudaapp.expenses.ExpenseService;
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
public class ExpenseController {

    private ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/expenses")
    String spendings(Model model) {
        List<ExpenseDto> expenses = expenseService.findAll();
        BigDecimal inTotal = expenseService.expensesInTotal();
        model.addAttribute("expenses", expenses);
        model.addAttribute("expense", new ExpenseDto());
        model.addAttribute("inTotal", inTotal);
        return "expenses";
    }

    @PostMapping("/addExpense")
    String addExpense(@Valid @ModelAttribute("expense") ExpenseDto expenseDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("expense", expenseDto);
            List<ExpenseDto> expenses = expenseService.findAll();
            BigDecimal inTotal = expenseService.expensesInTotal();
            model.addAttribute("expenses", expenses);
            model.addAttribute("inTotal", inTotal);
            return "expenses";
        }
        expenseService.save(expenseDto);
        List<ExpenseDto> expenses = expenseService.findAll();
        BigDecimal inTotal = expenseService.expensesInTotal();
        model.addAttribute("expenses", expenses);
        model.addAttribute("inTotal", inTotal);
        return "expenses";
    }
}
