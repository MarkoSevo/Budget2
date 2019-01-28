package com.biss.demo.Budget2.service.impl;

import com.biss.demo.Budget2.dto.HardwareDetailsDto;
import com.biss.demo.Budget2.model.Hardware;
import com.biss.demo.Budget2.model.HardwareType;
import com.biss.demo.Budget2.repository.HardwareJpaRepository;
import com.biss.demo.Budget2.repository.HardwareTypeJpaRepository;
import com.biss.demo.Budget2.service.HardwareDetailsService;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class HardwareDetailsServiceImpl implements HardwareDetailsService {

    private final HardwareJpaRepository hardwareJpaRepository;
    private final HardwareTypeJpaRepository hardwareTypeJpaRepository;
    private final ConversionService conversionService;

    public HardwareDetailsServiceImpl(HardwareJpaRepository hardwareJpaRepository, HardwareTypeJpaRepository hardwareTypeJpaRepository, ConversionService conversionService) {
        this.hardwareJpaRepository = hardwareJpaRepository;
        this.hardwareTypeJpaRepository = hardwareTypeJpaRepository;
        this.conversionService = conversionService;
    }

    @Override
    public HardwareDetailsDto findByHardwareType(String hardwareType) {
        HardwareDetailsDto dto = new HardwareDetailsDto();
        return dto;
    }

    @Override
    public HardwareDetailsDto save(HardwareDetailsDto hardwareDetailsDto) {
        Hardware hardware = new Hardware();
        Hardware.builder().build().setId(hardware.getId());
        Hardware.builder().build().setSerialNumber(hardware.getSerialNumber());
        Hardware.builder().build().setPrice(hardware.getPrice());
        Hardware.builder().build().setHardwareType(hardware.getHardwareType());
        return conversionService.convert(hardware, HardwareDetailsDto.class);
    }
}

