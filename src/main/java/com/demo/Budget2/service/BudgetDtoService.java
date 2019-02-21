package com.demo.Budget2.service;

import com.demo.Budget2.dto.BudgetDto;

import java.math.BigDecimal;

public interface BudgetDtoService {

    BigDecimal findBudgetByPosition (Long id);

    BudgetDto save(BudgetDto budgetDto);
}
