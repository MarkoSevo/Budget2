package com.biss.demo.Budget2.service;

import com.biss.demo.Budget2.dto.BudgetInputTransactionDto;
import com.biss.demo.Budget2.dto.BudgetOutputTransactionDto;
import com.biss.demo.Budget2.model.Person;

import java.math.BigDecimal;

public interface BudgetTransactionService {

    BudgetInputTransactionDto saveInput(BudgetInputTransactionDto budgetInputTransactionDto);

    BudgetOutputTransactionDto saveOutput(BudgetOutputTransactionDto budgetTransactionDto);

    BudgetInputTransactionDto saveInitialTransaction(BigDecimal amount, Long id);

    BudgetOutputTransactionDto hardwareTransaction(BigDecimal amount, Person id);

//    BudgetOutputTransactionDto personHardwareTransaction(Long id);

}
