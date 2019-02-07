package com.biss.demo.Budget2.service;

import com.biss.demo.Budget2.dto.BudgetInputTransactionDto;
import com.biss.demo.Budget2.dto.BudgetOutputTransactionDto;

import java.math.BigDecimal;

public interface BudgetTransactionService {

    BudgetInputTransactionDto saveInput(BudgetInputTransactionDto budgetInputTransactionDto);

    BudgetOutputTransactionDto saveOutput(BudgetOutputTransactionDto budgetTransactionDto);

    BigDecimal saveInitialTransaction(Long id);

}
