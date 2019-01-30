package com.biss.demo.Budget2.controller;

import com.biss.demo.Budget2.dto.BudgetTransactionDto;
import com.biss.demo.Budget2.model.BudgetTransaction;
import com.biss.demo.Budget2.repository.BudgetTransactionJpaRepository;
import com.biss.demo.Budget2.service.BudgetTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/budgettransactions")
public class BudgetTransactionController {

    private final BudgetTransactionJpaRepository jpaRepository;
    private final ConversionService conversionService;
    private final BudgetTransactionService budgetTransactionService;

    @Autowired
    public BudgetTransactionController(BudgetTransactionJpaRepository jpaRepository, ConversionService conversionService, BudgetTransactionService budgetTransactionService) {
        this.jpaRepository = jpaRepository;
        this.conversionService = conversionService;
        this.budgetTransactionService = budgetTransactionService;
    }

    @PostMapping (value = "/post")
    public BudgetTransactionDto save(@RequestBody BudgetTransactionDto budgetTransactionDto){
        return budgetTransactionService.save(budgetTransactionDto);
    }

    @GetMapping(value = "/id/{id}")
    public BudgetTransaction findBudgetTransactionById(final @PathVariable("id") Long id) {
        return jpaRepository.findBudgetTransactionById(id);
    }

    @GetMapping(value = "/all")
    public List<BudgetTransaction> allBudgets() {
        return jpaRepository.findAll();
    }
}



