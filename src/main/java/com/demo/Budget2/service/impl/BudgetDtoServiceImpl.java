package com.demo.Budget2.service.impl;

import com.demo.Budget2.dto.BudgetDto;
import com.demo.Budget2.model.Budget;
import com.demo.Budget2.repository.BudgetJpaRepository;
import com.demo.Budget2.service.BudgetDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BudgetDtoServiceImpl implements BudgetDtoService {

    private final ConversionService conversionService;
    private final BudgetJpaRepository budgetJpaRepository;

    @Autowired
    public BudgetDtoServiceImpl(ConversionService conversionService, BudgetJpaRepository budgetJpaRepository) {
        this.conversionService = conversionService;
        this.budgetJpaRepository = budgetJpaRepository;
    }

    @Override
    public BigDecimal findBudgetByPosition(Long id) {
        Budget budget = budgetJpaRepository.findBudgetById(id);
        BudgetDto dto = conversionService.convert(budget, BudgetDto.class);
        dto.setAmount(budget.getAmount());
        return dto.getAmount();
    }

    @Override
    public BudgetDto save(BudgetDto budgetDto) {
        Budget budget = conversionService.convert(budgetDto, Budget.class);
        budget.setAmount(budget.getAmount());
        budgetJpaRepository.save(budget);
        budgetDto.setId(budget.getId());
        return budgetDto;
    }

}
