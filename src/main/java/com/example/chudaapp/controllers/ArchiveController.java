package com.example.chudaapp.controllers;

import com.example.chudaapp.expenses.ExpenseDto;
import com.example.chudaapp.expenses.ExpenseService;
import com.example.chudaapp.income.IncomeDto;
import com.example.chudaapp.income.IncomeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ArchiveController {

    private Map<String, List<ExpenseDto>> archivesExpenses = new HashMap<>();

    private Map<String, List<IncomeDto>> archivesIncomes = new HashMap<>();

    private ExpenseService expenseService;

    private IncomeService incomeService;

    public ArchiveController(ExpenseService expenseService, IncomeService incomeService) {
        this.expenseService = expenseService;
        this.incomeService = incomeService;
    }

    @GetMapping("/archive")
    String archive() {
        return "archive";
    }

    @PostMapping("/archiveExpenses")
    String archiveExpenses (Model model, @RequestParam(required = false) String description){
        List<ExpenseDto> expenses = expenseService.findAll();
        archivesExpenses.put(description, expenses);
        expenseService.delete();
        model.addAttribute("expense", new ExpenseDto());
        return "expenses";
    }

    @GetMapping("/archiveList")
    String getArchiveList(@RequestParam String expenseDescription, Model model){
        List<ExpenseDto> expensesDto = archivesExpenses.get(expenseDescription);
        if (expensesDto == null) {
            List<IncomeDto> incomesDto = archivesIncomes.get(expenseDescription);
            model.addAttribute("list", incomesDto);
            model.addAttribute("listDescription", expenseDescription);
        } else {
            model.addAttribute("list", expensesDto);
            model.addAttribute("listDescription", expenseDescription);
        }
        return "archiveList";
    }

    @GetMapping("/archiveExpensesList")
    String getArchiveExpensesList (Model model){
        model.addAttribute("archiveList", archivesExpenses.keySet());
        return "archive";
    }

    @PostMapping("/archiveIncomes")
    String archiveIncomes (Model model, @RequestParam(required = false) String description){
        List<IncomeDto> incomes = incomeService.findAll();
        archivesIncomes.put(description, incomes);
        incomeService.delete();
        model.addAttribute("income", new IncomeDto());
        return "incomes";
    }

    @GetMapping("/archiveIncomesList")
    String getArchiveIncomesList (Model model){
        model.addAttribute("archiveList", archivesIncomes.keySet());
        return "archive";
    }
}
