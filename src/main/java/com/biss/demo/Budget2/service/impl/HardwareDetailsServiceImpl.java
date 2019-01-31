package com.biss.demo.Budget2.service.impl;

import com.biss.demo.Budget2.dto.HardwareDetailsDto;
import com.biss.demo.Budget2.model.Hardware;
import com.biss.demo.Budget2.repository.HardwareJpaRepository;
import com.biss.demo.Budget2.repository.HardwareTypeJpaRepository;
import com.biss.demo.Budget2.service.HardwareDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HardwareDetailsServiceImpl implements HardwareDetailsService {

    private final HardwareJpaRepository hardwareJpaRepository;
    private final HardwareTypeJpaRepository hardwareTypeJpaRepository;
    private final ConversionService conversionService;

    @Autowired
    public HardwareDetailsServiceImpl(HardwareJpaRepository hardwareJpaRepository, HardwareTypeJpaRepository hardwareTypeJpaRepository, ConversionService conversionService) {
        this.hardwareJpaRepository = hardwareJpaRepository;
        this.hardwareTypeJpaRepository = hardwareTypeJpaRepository;
        this.conversionService = conversionService;
    }

    @Override
    public HardwareDetailsDto save(HardwareDetailsDto hardwareDetailsDto) {
        Hardware hardware = conversionService.convert(hardwareDetailsDto,Hardware.class);
        hardware.setHardwareType(hardwareTypeJpaRepository.getOne(hardwareDetailsDto.getHardwareTypeId()));
        hardwareJpaRepository.save(hardware);
        return hardwareDetailsDto;
    }
    @Override
    public List<HardwareDetailsDto> findByHardwareType_Type(String hardwareType) {
        List<HardwareDetailsDto> hardwareDetailsDtoList = (List<HardwareDetailsDto>) conversionService.convert(hardwareJpaRepository.findAllByHardwareType_Type(hardwareType), TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Hardware.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(HardwareDetailsDto.class)));
        return hardwareDetailsDtoList;
    }

    @Override
    public List<HardwareDetailsDto> findAll() {
        return (List<HardwareDetailsDto>) conversionService.convert(hardwareJpaRepository.findAll(), TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Hardware.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(HardwareDetailsDto.class)));
    }
    @Override
    public List<HardwareDetailsDto> findAllByHardwareType_Id(Long id) {
        return (List<HardwareDetailsDto>) conversionService.convert(hardwareJpaRepository.findAllByHardwareType_Id(id), TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Hardware.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(HardwareDetailsDto.class)));
    }

    @Override
    public List<HardwareDetailsDto> findAllByHardwareType(String type) {
        return (List<HardwareDetailsDto>) conversionService.convert(hardwareJpaRepository.findAllByHardwareType_Type(type),  TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Hardware.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(HardwareDetailsDto.class)));
    }
}

