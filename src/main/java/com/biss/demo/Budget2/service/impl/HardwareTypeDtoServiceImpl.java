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
//    @Override
//    public HardwareTypeDto findHardwareByType(String type) {
//        Long hardwareType = hardwareTypeJpaRepository.findByType(type);
//        HardwareTypeDto dto = new HardwareTypeDto();
//        dto.setType(hardwareType);
//        return dto;
//    }
//}
////    @Override
////    public HardwareDetailsDto findHardwareById(Long id) {
////        Hardware hardware = hardwareJpaRepository.getOne(id);
////        HardwareDetailsDto dto = new HardwareDetailsDto();
////        dto.setPrice(hardware.getPrice());
////        dto.setSerialNumber(hardware.getSerialNumber());
////        return dto;
////    }