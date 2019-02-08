package com.biss.demo.Budget2.service.impl;

import com.biss.demo.Budget2.dto.*;
import com.biss.demo.Budget2.model.HardwareTransaction;
import com.biss.demo.Budget2.repository.HardwareJpaRepository;
import com.biss.demo.Budget2.repository.HardwareTransactionJpaRepository;
import com.biss.demo.Budget2.repository.HardwareTransactionTypeJpaRepository;
import com.biss.demo.Budget2.repository.PersonJpaRepository;
import com.biss.demo.Budget2.service.HardwareTransactionDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;


@Service
public class HardwareTransactionDtoServiceImpl implements HardwareTransactionDtoService {

    private final ConversionService conversionService;
    private final HardwareTransactionJpaRepository hardwareTransactionJpaRepository;
    private final HardwareJpaRepository hardwareJpaRepository;
    private final PersonJpaRepository personJpaRepository;
    private final HardwareTransactionTypeJpaRepository hardwareTransactionTypeJpaRepository;
    private final BudgetTransactionServiceImpl budgetTransactionService;

    @Autowired
    public HardwareTransactionDtoServiceImpl(HardwareTransactionJpaRepository hardwareTransactionJpaRepository, ConversionService conversionService, HardwareJpaRepository hardwareJpaRepository, PersonJpaRepository personJpaRepository, HardwareTransactionTypeJpaRepository hardwareTransactionTypeJpaRepository, BudgetTransactionServiceImpl budgetTransactionService) {
        this.conversionService = conversionService;
        this.hardwareTransactionJpaRepository = hardwareTransactionJpaRepository;
        this.hardwareJpaRepository = hardwareJpaRepository;
        this.personJpaRepository = personJpaRepository;
        this.hardwareTransactionTypeJpaRepository = hardwareTransactionTypeJpaRepository;
        this.budgetTransactionService = budgetTransactionService;
    }

    @Override
    public HardwareTransactionDto save(HardwareTransactionDto hardwareTransactionDto){
        HardwareTransaction hardwareTransaction = new HardwareTransaction();
        hardwareTransaction.setHardware(hardwareJpaRepository.getOne(hardwareTransactionDto.getHardwareId()));
        hardwareTransaction.setPerson(personJpaRepository.getOne(hardwareTransactionDto.getPersonId()));
        hardwareTransaction.setHardwareTransactionType(hardwareTransactionTypeJpaRepository.getOne(hardwareTransactionDto.getHardwareTransactionTypeId()));
        budgetTransactionService.hardwareTransaction(hardwareTransaction.getHardware().getPrice());
        hardwareTransactionJpaRepository.save(hardwareTransaction);
        return hardwareTransactionDto;
    }
}
