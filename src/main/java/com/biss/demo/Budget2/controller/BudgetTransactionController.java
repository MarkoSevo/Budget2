package com.biss.demo.Budget2.controller;

import com.biss.demo.Budget2.model.BudgetTransaction;
import com.biss.demo.Budget2.repository.BudgetTransactionJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/budgettransactions")
public class BudgetTransactionController {

    private final BudgetTransactionJpaRepository jpaRepository;

    @Autowired
    public BudgetTransactionController(BudgetTransactionJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
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



