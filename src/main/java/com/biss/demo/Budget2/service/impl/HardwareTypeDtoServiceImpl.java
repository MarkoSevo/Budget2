//package com.biss.demo.Budget2.service.impl;
//
//import com.biss.demo.Budget2.dto.HardwareDetailsDto;
//import com.biss.demo.Budget2.dto.HardwareTypeDto;
//import com.biss.demo.Budget2.model.Hardware;
//import com.biss.demo.Budget2.model.HardwareType;
//import com.biss.demo.Budget2.repository.HardwareTypeJpaRepository;
//import com.biss.demo.Budget2.service.HardwareTypeDtoService;
//import org.springframework.stereotype.Service;
//
//@Service
//public class HardwareTypeDtoServiceImpl implements HardwareTypeDtoService {
//
//    private final HardwareTypeJpaRepository hardwareTypeJpaRepository;
//
//    public HardwareTypeDtoServiceImpl(HardwareTypeJpaRepository hardwareTypeJpaRepository) {
//        this.hardwareTypeJpaRepository = hardwareTypeJpaRepository;
//    }
//
//
//    @Override
//    public HardwareType findHardwareByHardwareType_Type(String type) {
//        HardwareTypeDto dto = new HardwareTypeDto();
//        Hardware hardwareType = hardwareTypeJpaRepository.findHardwareByHardwareType_Type(type);
//        dto.setType(String.valueOf(hardwareTypeJpaRepository.findHardwareByHardwareType_Type(type)));
//        dto.setId(type.);
//        return null;
//    }
//}
