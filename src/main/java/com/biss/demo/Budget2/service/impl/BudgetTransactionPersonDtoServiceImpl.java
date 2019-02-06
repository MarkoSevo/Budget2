package com.biss.demo.Budget2.service.impl;

import com.biss.demo.Budget2.dto.BudgetTransactionPersonDto;
import com.biss.demo.Budget2.model.BudgetTransaction;
import com.biss.demo.Budget2.repository.BudgetTransactionJpaRepository;
import com.biss.demo.Budget2.service.BudgetTransactionPersonDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BudgetTransactionPersonDtoServiceImpl implements BudgetTransactionPersonDtoService {

    private final BudgetTransactionJpaRepository budgetTransactionJpaRepository;
    private final ConversionService conversionService;

    @Autowired
    public BudgetTransactionPersonDtoServiceImpl(BudgetTransactionJpaRepository budgetTransactionJpaRepository, ConversionService conversionService) {
        this.budgetTransactionJpaRepository = budgetTransactionJpaRepository;
        this.conversionService = conversionService;
    }

    @Override
    public List<BudgetTransactionPersonDto> findAllByPersonId(Long id) {
        return (List<BudgetTransactionPersonDto>) conversionService.convert(budgetTransactionJpaRepository.findAllByPerson_Id(id), TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(BudgetTransaction.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(BudgetTransactionPersonDto.class)));
    }
}
