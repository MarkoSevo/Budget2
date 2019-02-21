package com.demo.Budget2.controller;

import com.demo.Budget2.dto.HardwareTransactionTypeDto;
import com.demo.Budget2.model.HardwareTransactionType;
import com.demo.Budget2.repository.HardwareTransactionTypeJpaRepository;
import com.demo.Budget2.service.HardwareTransactionTypeDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/hardwaretransactiontypes")
public class HardwareTransactionTypeController {

    private final HardwareTransactionTypeJpaRepository jpaRepository;
    private final HardwareTransactionTypeDtoService hardwareTransactionTypeDtoService;

    @Autowired
    public HardwareTransactionTypeController(HardwareTransactionTypeJpaRepository jpaRepository, HardwareTransactionTypeDtoService hardwareTransactionTypeDtoService) {
        this.jpaRepository = jpaRepository;
        this.hardwareTransactionTypeDtoService = hardwareTransactionTypeDtoService;
    }

    @GetMapping(value = "id/{id}")
    public HardwareTransactionType findHardwareTransactionTypeById(final @PathVariable("id") Long id) {
        return jpaRepository.findHardwareTransactionTypeById(id);
    }
    @GetMapping(value = "/all")
    public List<HardwareTransactionTypeDto> allHardwareTransactionTypes() {
        return hardwareTransactionTypeDtoService.findAll();
    }
}



