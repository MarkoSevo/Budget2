package com.biss.demo.Budget2.service.impl;

import com.biss.demo.Budget2.dto.HardwareBudgetTransactionDto;
import com.biss.demo.Budget2.model.HardwareBudgetTransaction;
import com.biss.demo.Budget2.repository.HardwareBudgetTransactionRepository;
import com.biss.demo.Budget2.service.HardwareBudgetTransactionDtoService;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class HardwareBudgetTransactionDtoServiceImpl implements HardwareBudgetTransactionDtoService {

    private final ConversionService conversionService;
    private final HardwareBudgetTransactionRepository hardwareBudgetTransactionRepository;
    public HardwareBudgetTransactionDtoServiceImpl(ConversionService conversionService, HardwareBudgetTransactionRepository hardwareBudgetTransactionRepository) {
        this.conversionService = conversionService;
        this.hardwareBudgetTransactionRepository = hardwareBudgetTransactionRepository;
    }

    @Override
    public List<HardwareBudgetTransactionDto> findAllByPersonId(Long id) {
        HardwareBudgetTransactionDto dto = new HardwareBudgetTransactionDto();
        HardwareBudgetTransaction hardwareBudgetTransaction =new HardwareBudgetTransaction();
        return null;
    }
}
