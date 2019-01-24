package com.biss.demo.Budget2.service.impl;

import com.biss.demo.Budget2.dto.HardwareDetailsDto;
import com.biss.demo.Budget2.model.Hardware;
import com.biss.demo.Budget2.repository.HardwareJpaRepository;
import com.biss.demo.Budget2.repository.HardwareTypeJpaRepository;
import com.biss.demo.Budget2.service.HardwareDetailsService;
import org.springframework.stereotype.Service;

@Service
public class HardwareDetailsServiceImpl implements HardwareDetailsService {

    private final HardwareJpaRepository hardwareJpaRepository;
    private final HardwareTypeJpaRepository hardwareTypeJpaRepository;

    public HardwareDetailsServiceImpl(HardwareJpaRepository hardwareJpaRepository, HardwareTypeJpaRepository hardwareTypeJpaRepository) {
        this.hardwareJpaRepository = hardwareJpaRepository;
        this.hardwareTypeJpaRepository = hardwareTypeJpaRepository;
    }

    @Override
    public HardwareDetailsDto findByHardwareType(String hardwareType) {
        Hardware hardware = hardwareJpaRepository.findHardwareByHardwareType_Type(hardwareType);
        HardwareDetailsDto dto = new HardwareDetailsDto();
        dto.setId(hardware.getId());
        dto.setHardwareType((hardware.getHardwareType()));
        dto.setPrice(hardware.getPrice());
        return dto;
    }
}

