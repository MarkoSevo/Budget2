package com.biss.demo.Budget2.service;

import com.biss.demo.Budget2.converter.BudgetInputTransactionToBudgetInputTransactionDto;
import com.biss.demo.Budget2.dto.BudgetInputTransactionDto;
import com.biss.demo.Budget2.dto.BudgetOutputTransactionDto;
import com.biss.demo.Budget2.model.BudgetTransaction;


import java.util.List;

public interface BudgetTransactionService {

    BudgetInputTransactionDto saveInput(BudgetInputTransactionDto budgetInputTransactionDto);

    BudgetOutputTransactionDto saveOutput(BudgetOutputTransactionDto budgetTransactionDto);

    List<BudgetInputTransactionToBudgetInputTransactionDto> findAll();

    BudgetInputTransactionDto findInitialBudget(Long id);
}
