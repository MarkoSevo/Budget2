package com.biss.demo.Budget2.service.impl;

import com.biss.demo.Budget2.dto.BudgetTransactionDto;
import com.biss.demo.Budget2.model.BudgetTransaction;
import com.biss.demo.Budget2.repository.BudgetTransactionJpaRepository;
import com.biss.demo.Budget2.repository.PersonJpaRepository;
import com.biss.demo.Budget2.service.BudgetTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

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
    public BudgetTransactionDto save(BudgetTransactionDto budgetTransactionDto){
        BudgetTransaction budgetTransaction = conversionService.convert(budgetTransactionDto, BudgetTransaction.class);
        budgetTransaction.setInputAmount(budgetTransaction.getInputAmount());
        budgetTransaction.setOutputAmount(budgetTransaction.getOutputAmount());
        budgetTransaction.setPerson(personJpaRepository.getOne(budgetTransactionDto.getPersonId()));
        budgetTransactionJpaRepository.save(budgetTransaction);
        return budgetTransactionDto;
    }
}
//    HardwareTransaction hardwareTransaction = conversionService.convert(hardwareTransactionDto, HardwareTransaction.class);
//        hardwareTransaction.setHardware(hardwareJpaRepository.getOne(hardwareTransactionDto.getHardwareId()));
//                hardwareTransaction.setPerson(personJpaRepository.getOne(hardwareTransactionDto.getPersonId()));
//                hardwareTransaction.setHardwareTransactionType(hardwareTransactionTypeJpaRepository.getOne(hardwareTransactionDto.getHardwareTransactionTypeId()));
//                hardwareTransactionJpaRepository.save(hardwareTransaction);
//                return hardwareTransactionDto;