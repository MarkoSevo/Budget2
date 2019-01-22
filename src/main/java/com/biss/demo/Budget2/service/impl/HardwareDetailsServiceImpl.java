package com.biss.demo.Budget2.service.impl;

import com.biss.demo.Budget2.dto.HardwareDetailsDto;
import com.biss.demo.Budget2.model.Hardware;
import com.biss.demo.Budget2.repository.HardwareJpaRepository;
import com.biss.demo.Budget2.service.HardwareDetailsService;
import org.springframework.stereotype.Service;

@Service
public class HardwareDetailsServiceImpl implements HardwareDetailsService {

    private final HardwareJpaRepository hardwareJpaRepository;

    public HardwareDetailsServiceImpl(HardwareJpaRepository hardwareJpaRepository) {
        this.hardwareJpaRepository = hardwareJpaRepository;
    }

    @Override
    public HardwareDetailsDto findByHardwareType(String hardwareType) {
        Hardware hardware = hardwareJpaRepository.findHardwareByHardwareType(hardwareType);
        HardwareDetailsDto dto = new HardwareDetailsDto();
        //dto.setId(hardwareJpaRepository.findHardwareByHardwareType(hardware.getId()));
        return dto;
    }
}

