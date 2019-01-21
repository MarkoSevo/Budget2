package com.biss.demo.Budget2.service.impl;

import com.biss.demo.Budget2.model.HardwareTransactionType;
import com.biss.demo.Budget2.repository.HardwareTransactionJpaRepository;
import com.biss.demo.Budget2.repository.HardwareTransactionTypeJpaRepository;
import com.biss.demo.Budget2.service.HardwareTransactionTypeDtoService;
import org.springframework.stereotype.Service;

@Service
public class HardwareTransactionTypeDtoServiceImpl implements HardwareTransactionTypeDtoService {

    private final HardwareTransactionTypeJpaRepository hardwareTransactionJpaTypeRepository;

    public HardwareTransactionTypeDtoServiceImpl(HardwareTransactionTypeJpaRepository hardwareTransactionJpaTypeRepository) {
        this.hardwareTransactionJpaTypeRepository = hardwareTransactionJpaTypeRepository;
    }


    @Override
    public HardwareTransactionType findAllByHardwareTransactionType(Long id) {
        HardwareTransactionType hardwareTransactionType = hardwareTransactionJpaTypeRepository.getOne(id);
        HardwareTransactionType dto = new HardwareTransactionType();
        dto.setId(hardwareTransactionType.getId());
        return dto;
    }
}
