package com.demo.Budget2.controller;

import com.demo.Budget2.dto.BudgetInputTransactionDto;
import com.demo.Budget2.dto.BudgetOutputTransactionDto;
import com.demo.Budget2.dto.BudgetTransactionPersonDto;
import com.demo.Budget2.model.BudgetTransaction;
import com.demo.Budget2.repository.BudgetTransactionJpaRepository;
import com.demo.Budget2.service.BudgetTransactionService;
import com.demo.Budget2.service.impl.BudgetTransactionPersonDtoServiceImpl;
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
    private final BudgetTransactionPersonDtoServiceImpl budgetTransactionPersonDtoService;

    @Autowired
    public BudgetTransactionController(BudgetTransactionJpaRepository jpaRepository, ConversionService conversionService, BudgetTransactionService budgetTransactionService, BudgetTransactionPersonDtoServiceImpl budgetTransactionPersonDtoService) {
        this.jpaRepository = jpaRepository;
        this.conversionService = conversionService;
        this.budgetTransactionService = budgetTransactionService;
        this.budgetTransactionPersonDtoService = budgetTransactionPersonDtoService;
    }

    @PostMapping (value = "/post/inputAmount")
    public BudgetInputTransactionDto saveInput(@RequestBody BudgetInputTransactionDto budgetTransactionDto){
        return budgetTransactionService.saveInput(budgetTransactionDto);
    }

    @PostMapping (value = "/post/outputAmount")
    public BudgetOutputTransactionDto saveOutput(@RequestBody BudgetOutputTransactionDto budgetOutputTransactionDto){
        return budgetTransactionService.saveOutput(budgetOutputTransactionDto);
    }

    @GetMapping(value = "/id/{id}")
    public BudgetTransaction findBudgetTransactionById(final @PathVariable("id") Long id) {
        return jpaRepository.findBudgetTransactionById(id);
    }

    @GetMapping(value = "/personId/{id}")
    public List<BudgetTransactionPersonDto> findBudgetTransactionByPersonId(final @PathVariable("id")Long id){
        return budgetTransactionPersonDtoService.findAllByPersonId(id);
    }

    @GetMapping(value = "/all")
    public List<BudgetTransaction> allBudgets() {
        return jpaRepository.findAll();
    }
}



