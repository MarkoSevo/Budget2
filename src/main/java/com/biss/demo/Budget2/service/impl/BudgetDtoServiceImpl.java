package com.biss.demo.Budget2.service.impl;

import com.biss.demo.Budget2.dto.BudgetDto;
import com.biss.demo.Budget2.model.Budget;
import com.biss.demo.Budget2.repository.BudgetJpaRepository;
import com.biss.demo.Budget2.repository.BudgetPositionJpaRepository;
import com.biss.demo.Budget2.service.BudgetDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BudgetDtoServiceImpl implements BudgetDtoService {

    private final ConversionService conversionService;
    private final BudgetJpaRepository budgetJpaRepository;
    private final BudgetPositionJpaRepository budgetPositionJpaRepository;
    private final InitialBudgetTransactionServiceImpl initialBudgetTransactionService;

    @Autowired
    public BudgetDtoServiceImpl(ConversionService conversionService, BudgetJpaRepository budgetJpaRepository, BudgetPositionJpaRepository budgetPositionJpaRepository, InitialBudgetTransactionServiceImpl initialBudgetTransactionService) {
        this.conversionService = conversionService;
        this.budgetJpaRepository = budgetJpaRepository;
        this.budgetPositionJpaRepository = budgetPositionJpaRepository;
        this.initialBudgetTransactionService = initialBudgetTransactionService;
    }

    @Override
    public BigDecimal findBudgetByPosition(Long id) {
        Budget budget = budgetJpaRepository.findBudgetById(id);
        BudgetDto dto = conversionService.convert(budget, BudgetDto.class);
        dto.setAmount(budget.getAmount());
        return dto.getAmount();
    }
}
