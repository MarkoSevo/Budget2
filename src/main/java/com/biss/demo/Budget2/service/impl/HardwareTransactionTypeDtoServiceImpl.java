package com.biss.demo.Budget2.service.impl;

import com.biss.demo.Budget2.dto.HardwareTransactionTypeDto;
import com.biss.demo.Budget2.model.HardwareTransactionType;
import com.biss.demo.Budget2.repository.HardwareTransactionTypeJpaRepository;
import com.biss.demo.Budget2.service.HardwareTransactionTypeDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HardwareTransactionTypeDtoServiceImpl implements HardwareTransactionTypeDtoService {

    private final HardwareTransactionTypeJpaRepository transactionTypeJpaRepository;
    private final ConversionService conversionService;

    @Autowired
    public HardwareTransactionTypeDtoServiceImpl(HardwareTransactionTypeJpaRepository hardwareTransactionJpaTypeRepository, ConversionService conversionService) {
        this.transactionTypeJpaRepository = hardwareTransactionJpaTypeRepository;
        this.conversionService = conversionService;
    }

    @Override
    public List<HardwareTransactionTypeDto> findAll() {
     return (List<HardwareTransactionTypeDto>) conversionService.convert(transactionTypeJpaRepository.findAll(), TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(HardwareTransactionType.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(HardwareTransactionTypeDto.class)));
    }
}
