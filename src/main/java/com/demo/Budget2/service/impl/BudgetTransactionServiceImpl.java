package com.demo.Budget2.service.impl;

import com.demo.Budget2.dto.BudgetInputTransactionDto;
import com.demo.Budget2.dto.BudgetOutputTransactionDto;
import com.demo.Budget2.model.BudgetTransaction;
import com.demo.Budget2.model.Person;
import com.demo.Budget2.repository.BudgetTransactionJpaRepository;
import com.demo.Budget2.repository.PersonJpaRepository;
import com.demo.Budget2.service.BudgetTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class BudgetTransactionServiceImpl implements BudgetTransactionService {

    private final ConversionService conversionService;
    private final BudgetTransactionJpaRepository budgetTransactionJpaRepository;
    private final PersonJpaRepository personJpaRepository;

        @Autowired
        public BudgetTransactionServiceImpl(ConversionService conversionService, BudgetTransactionJpaRepository budgetTransactionJpaRepository, PersonJpaRepository personJpaRepository) {
            this.conversionService = conversionService;
            this.budgetTransactionJpaRepository = budgetTransactionJpaRepository;
            this.personJpaRepository = personJpaRepository;
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
        public BudgetInputTransactionDto saveInitialTransaction(BigDecimal amount,Long id) {
            BudgetTransaction budgetTransaction = new BudgetTransaction();
            BudgetInputTransactionDto budgetInputTransactionDto = new BudgetInputTransactionDto();
            conversionService.convert(budgetInputTransactionDto, BudgetTransaction.class);
            budgetTransaction.setInputAmount(amount);
            budgetTransaction.setPerson(personJpaRepository.getOne(id));
            budgetTransactionJpaRepository.save(budgetTransaction);
            return budgetInputTransactionDto;
        }

        @Override
        public BudgetOutputTransactionDto hardwareTransaction(BigDecimal amount, Person id) {
            BudgetTransaction budgetTransaction = new BudgetTransaction();
            BudgetOutputTransactionDto budgetOutputTransactionDto = new BudgetOutputTransactionDto();
            conversionService.convert(budgetOutputTransactionDto, BudgetTransaction.class);
            budgetTransaction.setOutputAmount(amount);
            budgetTransaction.setPerson(id);
            budgetTransactionJpaRepository.save(budgetTransaction);
            return budgetOutputTransactionDto;
        }

}
