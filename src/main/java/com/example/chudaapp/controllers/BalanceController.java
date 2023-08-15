package com.example.chudaapp.controllers;

import com.example.chudaapp.expenses.ExpenseService;
import com.example.chudaapp.income.IncomeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;

@Controller
public class BalanceController {

    private IncomeService incomeService;

    private ExpenseService expenseService;

    public BalanceController(IncomeService incomeService, ExpenseService expenseService) {
        this.incomeService = incomeService;
        this.expenseService = expenseService;
    }

    @GetMapping("/balance")
    String balance (Model model){
        BigDecimal incomesInTotal = incomeService.incomesInTotal();
        BigDecimal expensesInTotal = expenseService.expensesInTotal();
        model.addAttribute("incomesTotal", incomesInTotal);
        model.addAttribute("expensesTotal", expensesInTotal);
        model.addAttribute("balance", incomesInTotal.subtract(expensesInTotal));
        return "balance";
    }
}
