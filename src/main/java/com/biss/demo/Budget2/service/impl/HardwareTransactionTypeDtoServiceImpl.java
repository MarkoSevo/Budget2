package com.biss.demo.Budget2.service.impl;

import com.biss.demo.Budget2.dto.HardwareTransactionTypeDto;
import com.biss.demo.Budget2.dto.PositionDto;
import com.biss.demo.Budget2.model.HardwareTransactionType;
import com.biss.demo.Budget2.model.Position;
import com.biss.demo.Budget2.repository.HardwareTransactionTypeJpaRepository;
import com.biss.demo.Budget2.service.HardwareTransactionTypeDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HardwareTransactionTypeDtoServiceImpl implements HardwareTransactionTypeDtoService {

    private final HardwareTransactionTypeJpaRepository hardwareTransactionJpaTypeRepository;
    private final ConversionService conversionService;

    @Autowired
    public HardwareTransactionTypeDtoServiceImpl(HardwareTransactionTypeJpaRepository hardwareTransactionJpaTypeRepository, ConversionService conversionService) {
        this.hardwareTransactionJpaTypeRepository = hardwareTransactionJpaTypeRepository;
        this.conversionService = conversionService;
    }
    
}
