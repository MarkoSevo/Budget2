package com.biss.demo.Budget2.controller;

import com.biss.demo.Budget2.dto.HardwareTransactionTypeDto;
import com.biss.demo.Budget2.dto.PositionDto;
import com.biss.demo.Budget2.model.HardwareTransactionType;
import com.biss.demo.Budget2.model.Position;
import com.biss.demo.Budget2.repository.HardwareTransactionTypeJpaRepository;
import com.biss.demo.Budget2.service.HardwareTransactionTypeDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/hardwaretransactiontypes")
public class HardwareTransactionTypeController {

    private final HardwareTransactionTypeJpaRepository jpaRepository;
    private final HardwareTransactionTypeDtoService hardwareTransactionTypeDtoService;
    private final ConversionService conversionService;

    @Autowired
    public HardwareTransactionTypeController(HardwareTransactionTypeJpaRepository jpaRepository, HardwareTransactionTypeDtoService hardwareTransactionTypeDtoService, ConversionService conversionService) {
        this.jpaRepository = jpaRepository;
        this.hardwareTransactionTypeDtoService = hardwareTransactionTypeDtoService;
        this.conversionService = conversionService;
    }

    @GetMapping(value = "id/{id}")
    public HardwareTransactionType findHardwareTransactionTypeById(final @PathVariable("id") Long id) {
        return jpaRepository.findHardwareTransactionTypeById(id);
    }
    @GetMapping(value = "/all")
    public List<HardwareTransactionTypeDto> allHardwareTransactionTypes() {
        return (List<HardwareTransactionTypeDto>) conversionService.convert(jpaRepository.findAll(), TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(HardwareTransactionType.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(HardwareTransactionTypeDto.class)));
    }
}



