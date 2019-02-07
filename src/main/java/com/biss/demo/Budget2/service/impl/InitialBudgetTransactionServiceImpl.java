package com.biss.demo.Budget2.service.impl;

import com.biss.demo.Budget2.dto.InitialBudgetTransactionDto;
import com.biss.demo.Budget2.model.BudgetTransaction;
import com.biss.demo.Budget2.service.InitialBudgetTransactionService;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class InitialBudgetTransactionServiceImpl implements InitialBudgetTransactionService {

    private final ConversionService conversionService;
    private final BudgetDtoServiceImpl budgetDtoServiceImpl;
    public InitialBudgetTransactionServiceImpl(ConversionService conversionService, BudgetDtoServiceImpl budgetDtoServiceImpl) {
        this.conversionService = conversionService;
        this.budgetDtoServiceImpl = budgetDtoServiceImpl;
    }

    @Override
    public InitialBudgetTransactionDto saveInitialTransaction() {
        InitialBudgetTransactionDto initialBudgetTransactionDto = new InitialBudgetTransactionDto();
        BudgetTransaction budgetTransaction =  conversionService.convert(initialBudgetTransactionDto, BudgetTransaction.class);
        initialBudgetTransactionDto.setAmount(budgetDtoServiceImpl.findBudgetByPosition(initialBudgetTransactionDto.getPersonId()));
        return initialBudgetTransactionDto;
    }
}
