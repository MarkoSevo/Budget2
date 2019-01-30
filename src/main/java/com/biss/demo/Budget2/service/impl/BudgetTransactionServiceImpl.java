package com.biss.demo.Budget2.service.impl;

import com.biss.demo.Budget2.dto.BudgetTransactionDto;
import com.biss.demo.Budget2.model.BudgetTransaction;
import com.biss.demo.Budget2.repository.BudgetTransactionJpaRepository;
import com.biss.demo.Budget2.service.BudgetTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class BudgetTransactionServiceImpl implements BudgetTransactionService {

private final ConversionService conversionService;
private final BudgetTransactionJpaRepository budgetTransactionJpaRepository;

    @Autowired
    public BudgetTransactionServiceImpl(ConversionService conversionService, BudgetTransactionJpaRepository budgetTransactionJpaRepository) {
        this.conversionService = conversionService;
        this.budgetTransactionJpaRepository = budgetTransactionJpaRepository;
    }

    @Override
    public BudgetTransactionDto save(BudgetTransactionDto budgetTransactionDto){
        BudgetTransaction budgetTransaction = conversionService.convert(budgetTransactionDto, BudgetTransaction.class);
        budgetTransactionJpaRepository.save(budgetTransaction);
        return budgetTransactionDto;
    }
}
