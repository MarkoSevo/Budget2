package com.biss.demo.Budget2.service.impl;

import com.biss.demo.Budget2.converter.BudgetInputTransactionToBudgetInputTransactionDto;
import com.biss.demo.Budget2.dto.BudgetInputTransactionDto;
import com.biss.demo.Budget2.dto.BudgetOutputTransactionDto;
import com.biss.demo.Budget2.model.BudgetTransaction;
import com.biss.demo.Budget2.repository.BudgetPositionJpaRepository;
import com.biss.demo.Budget2.repository.BudgetTransactionJpaRepository;
import com.biss.demo.Budget2.repository.PersonJpaRepository;
import com.biss.demo.Budget2.service.BudgetTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BudgetTransactionServiceImpl implements BudgetTransactionService {

private final ConversionService conversionService;
private final BudgetTransactionJpaRepository budgetTransactionJpaRepository;
private final PersonJpaRepository personJpaRepository;
private final BudgetPositionJpaRepository budgetPositionJpaRepository;

    @Autowired
    public BudgetTransactionServiceImpl(ConversionService conversionService, BudgetTransactionJpaRepository budgetTransactionJpaRepository, PersonJpaRepository personJpaRepository, BudgetPositionJpaRepository budgetPositionJpaRepository) {
        this.conversionService = conversionService;
        this.budgetTransactionJpaRepository = budgetTransactionJpaRepository;
        this.personJpaRepository = personJpaRepository;
        this.budgetPositionJpaRepository = budgetPositionJpaRepository;
    }

    @Override
    public BudgetInputTransactionDto saveInput(BudgetInputTransactionDto budgetInputTransactionDto){
        BudgetTransaction budgetTransaction = conversionService.convert(budgetInputTransactionDto, BudgetTransaction.class);
        budgetTransaction.setInputAmount(budgetTransaction.getInputAmount());
        budgetTransaction.setPerson(personJpaRepository.getOne(budgetInputTransactionDto.getPersonId()));
        budgetTransactionJpaRepository.save(budgetTransaction);
        return budgetInputTransactionDto;
    }

    @Override
    public BudgetOutputTransactionDto saveOutput(BudgetOutputTransactionDto budgetOutputTransactionDto) {
        BudgetTransaction budgetTransaction = conversionService.convert(budgetOutputTransactionDto, BudgetTransaction.class);
        budgetTransaction.setOutputAmount(budgetTransaction.getOutputAmount());
        budgetTransaction.setPerson(personJpaRepository.getOne(budgetOutputTransactionDto.getPersonId()));
        budgetTransactionJpaRepository.save(budgetTransaction);
        return budgetOutputTransactionDto;
    }

    @Override
    public List<BudgetInputTransactionToBudgetInputTransactionDto> findAll() {
        return null;
    }

    @Override
    public BudgetInputTransactionDto findInitialBudget(Long id) {
//        BudgetInputTransactionDto budgetInputTransactionDto = new BudgetInputTransactionDto()
//        BudgetTransaction budgetTransaction = conversionService.convert(budgetInputTransactionDto, BudgetTransaction.class);
//        budgetTransaction.setInputAmount(budgetPositionJpaRepository.findByPosition_Id(id));
        return null;
    }
}
