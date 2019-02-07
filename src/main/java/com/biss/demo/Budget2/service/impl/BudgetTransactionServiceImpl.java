package com.biss.demo.Budget2.service.impl;

import com.biss.demo.Budget2.dto.BudgetInputTransactionDto;
import com.biss.demo.Budget2.dto.BudgetOutputTransactionDto;
import com.biss.demo.Budget2.model.BudgetTransaction;
import com.biss.demo.Budget2.repository.BudgetTransactionJpaRepository;
import com.biss.demo.Budget2.repository.PersonJpaRepository;
import com.biss.demo.Budget2.service.BudgetTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class BudgetTransactionServiceImpl implements BudgetTransactionService {

    private final ConversionService conversionService;
    private final BudgetTransactionJpaRepository budgetTransactionJpaRepository;
    private final PersonJpaRepository personJpaRepository;
    private final BudgetDtoServiceImpl budgetDtoServiceImpl;
    private final InitialBudgetTransactionServiceImpl initialBudgetTransactionService;

        @Autowired
        public BudgetTransactionServiceImpl(ConversionService conversionService, BudgetTransactionJpaRepository budgetTransactionJpaRepository, PersonJpaRepository personJpaRepository, BudgetDtoServiceImpl budgetDtoServiceImpl, InitialBudgetTransactionServiceImpl initialBudgetTransactionService) {
            this.conversionService = conversionService;
            this.budgetTransactionJpaRepository = budgetTransactionJpaRepository;
            this.personJpaRepository = personJpaRepository;
            this.budgetDtoServiceImpl = budgetDtoServiceImpl;
            this.initialBudgetTransactionService = initialBudgetTransactionService;
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
    public BigDecimal saveInitialTransaction(Long id) {

        BudgetInputTransactionDto budgetInputTransactionDto = new BudgetInputTransactionDto();
        BudgetTransaction budgetTransaction = conversionService.convert(budgetInputTransactionDto, BudgetTransaction.class);
//        budgetTransaction.setInputAmount(initialBudgetTransactionService.saveInitialTransaction());
        return budgetInputTransactionDto.getAmount();
    }

}
