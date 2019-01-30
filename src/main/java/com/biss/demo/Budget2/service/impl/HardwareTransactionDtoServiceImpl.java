package com.biss.demo.Budget2.service.impl;

import com.biss.demo.Budget2.dto.HardwareTransactionDto;
import com.biss.demo.Budget2.model.HardwareTransaction;
import com.biss.demo.Budget2.repository.HardwareTransactionJpaRepository;
import com.biss.demo.Budget2.service.HardwareTransactionDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class HardwareTransactionDtoServiceImpl implements HardwareTransactionDtoService {

    private final ConversionService conversionService;
    private final HardwareTransactionJpaRepository hardwareTransactionJpaRepository;

    @Autowired
    public HardwareTransactionDtoServiceImpl(HardwareTransactionJpaRepository hardwareTransactionJpaRepository, ConversionService conversionService) {
        this.conversionService = conversionService;
        this.hardwareTransactionJpaRepository = hardwareTransactionJpaRepository;
    }

    @Override
    public HardwareTransactionDto save(HardwareTransactionDto hardwareTransactionDto){
        HardwareTransaction hardwareTransaction = conversionService.convert(hardwareTransactionDto, HardwareTransaction.class);
        hardwareTransactionJpaRepository.save(hardwareTransaction);
        return hardwareTransactionDto;
    }
}