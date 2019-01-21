package com.biss.demo.Budget2.service.impl;

import com.biss.demo.Budget2.dto.HardwareDto;
import com.biss.demo.Budget2.model.Hardware;
import com.biss.demo.Budget2.repository.HardwareJpaRepository;
import com.biss.demo.Budget2.service.HardwareDtoService;
import org.springframework.stereotype.Service;

@Service
public class HardwareDtoServiceImpl implements HardwareDtoService {

    private final HardwareJpaRepository hardwareJpaRepository;

    public HardwareDtoServiceImpl(HardwareJpaRepository hardwareJpaRepository) {
        this.hardwareJpaRepository = hardwareJpaRepository;
    }

    @Override
    public HardwareDto findHardwareById(Long id) {
        Hardware hardware = hardwareJpaRepository.getOne(id);
        HardwareDto dto = new HardwareDto();
        dto.setHardwareType(hardware.getHardwareType());
        dto.setPrice(hardware.getPrice());
        dto.setSerialNumber(hardware.getSerialNumber());
        dto.setHardwareTransactionTypeList(hardwareJpaRepository.findAllByStatus(hardware.getId()));
        return dto;
    }

}
