//package com.biss.demo.Budget2.controller;
//
//import com.biss.demo.Budget2.model.BudgetTransactionType;
//import com.biss.demo.Budget2.repository.BudgetTransactionTypeJpaRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/budgettransactiontypes")
//public class BudgetTransactionTypeController {
//
//
//    private final BudgetTransactionTypeJpaRepository jpaRepository;
//
//    @Autowired
//    public BudgetTransactionTypeController(BudgetTransactionTypeJpaRepository jpaRepository) {
//        this.jpaRepository = jpaRepository;
//    }
//
//    @GetMapping(value = "/{id}")
//    public BudgetTransactionType get(@PathVariable("id") Long id) {
//        return jpaRepository.findBudgetTransactionTypeById(id);
//    }
//
//    @GetMapping(value = "/all")
//    public List<BudgetTransactionType> all() {
//        return jpaRepository.findAll();
//    }
//
//}
//


