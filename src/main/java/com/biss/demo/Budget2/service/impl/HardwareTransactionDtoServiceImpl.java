//package com.biss.demo.Budget2.service.impl;
//
//import com.biss.demo.Budget2.dto.HardwareDto;
//import com.biss.demo.Budget2.dto.HardwareTransactionDto;
//import com.biss.demo.Budget2.model.Hardware;
//import com.biss.demo.Budget2.model.HardwareTransaction;
//import com.biss.demo.Budget2.repository.HardwareTransactionJpaRepository;
//import com.biss.demo.Budget2.repository.PersonJpaRepository;
//import com.biss.demo.Budget2.service.HardwareTransactionDtoService;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class HardwareTransactionDtoServiceImpl implements HardwareTransactionDtoService {
//
//    private final HardwareTransactionJpaRepository hardwareTransactionJpaRepository;
//    private final PersonJpaRepository personJpaRepository;
//
//    public HardwareTransactionDtoServiceImpl(HardwareTransactionJpaRepository hardwareTransactionJpaRepository, PersonJpaRepository personJpaRepository) {
//        this.hardwareTransactionJpaRepository = hardwareTransactionJpaRepository;
//        this.personJpaRepository = personJpaRepository;
//    }
//
//
//    @Override
//    public HardwareTransactionDto findHardwareTransactionsByHardwareId(Long id) {
//        return null;
//    }
//
//    @Override
//    public List<HardwareTransactionDto> findAllByStatus(Long id) {
//        Hardware hardware = hardwareJpaRepository.getOne(id);
//        HardwareDto dto = new HardwareDto();
//        dto.setHardwareType(hardware.getHardwareType());
//        dto.setPrice(hardware.getPrice());
//        dto.setSerialNumber(hardware.getSerialNumber());
//        return
//    }
//
//}