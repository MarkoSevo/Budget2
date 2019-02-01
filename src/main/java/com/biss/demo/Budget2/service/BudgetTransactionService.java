package com.biss.demo.Budget2.service;

import com.biss.demo.Budget2.converter.BudgetInputTransactionToBudgetInputTransactionDto;
import com.biss.demo.Budget2.dto.BudgetInputTransactionDto;
import com.biss.demo.Budget2.dto.BudgetOutputTransactionDto;


import java.util.List;

public interface BudgetTransactionService {

    BudgetInputTransactionDto saveInput(BudgetInputTransactionDto budgetInputTransactionDto);

    BudgetOutputTransactionDto saveOutput(BudgetOutputTransactionDto budgetTransactionDto);

    List<BudgetInputTransactionToBudgetInputTransactionDto> findAll();


}
