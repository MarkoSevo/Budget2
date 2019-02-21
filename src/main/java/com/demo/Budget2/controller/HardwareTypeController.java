package com.demo.Budget2.controller;

import com.demo.Budget2.dto.HardwareDetailsDto;
import com.demo.Budget2.dto.HardwareTypeDto;
import com.demo.Budget2.model.Hardware;
import com.demo.Budget2.model.HardwareType;
import com.demo.Budget2.repository.HardwareJpaRepository;
import com.demo.Budget2.repository.HardwareTypeJpaRepository;
import com.demo.Budget2.service.HardwareTypeDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/hardwaretypes")
public class HardwareTypeController {

    private final HardwareTypeJpaRepository jpaRepository;
    private final ConversionService conversionService;
    private final HardwareTypeDtoService hardwareTypeDtoService;
    private final HardwareJpaRepository hardwareJpaRepository;

    @Autowired
    public HardwareTypeController(HardwareTypeJpaRepository jpaRepository, ConversionService conversionService, HardwareTypeDtoService hardwareTypeDtoService, HardwareJpaRepository hardwareJpaRepository) {
        this.jpaRepository = jpaRepository;
        this.conversionService = conversionService;
        this.hardwareTypeDtoService = hardwareTypeDtoService;
        this.hardwareJpaRepository = hardwareJpaRepository;
    }

    @PostMapping(value = "/post")
    public HardwareTypeDto save(@RequestBody HardwareTypeDto newHardwareType) {
        return hardwareTypeDtoService.save(newHardwareType);
    }

    @GetMapping(value = "/all")
    public List<HardwareTypeDto> findAll() {
        return hardwareTypeDtoService.findAll();
    }

    @GetMapping(value = "/type/{type}")
    public List<HardwareTypeDto> findAllByType(final @PathVariable String type){
        return (List<HardwareTypeDto>) conversionService.convert(jpaRepository.findHardwareTypeIdByType(type), TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(HardwareType.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(HardwareTypeDto.class)));
    }

    @GetMapping (value = "/hardwareType/{hardwareType}")
    public List<HardwareDetailsDto> findAllByHardwareType(final @PathVariable String hardwareType) {
        return (List<HardwareDetailsDto>) conversionService.convert(hardwareJpaRepository.findAllByHardwareType_Type(hardwareType), TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Hardware.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(HardwareDetailsDto.class)));
    }

}



