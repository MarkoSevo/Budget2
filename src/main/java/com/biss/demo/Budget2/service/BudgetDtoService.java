package com.biss.demo.Budget2.service;

import java.math.BigDecimal;

public interface BudgetDtoService {

    BigDecimal findBudgetByPosition (Long id);
}
