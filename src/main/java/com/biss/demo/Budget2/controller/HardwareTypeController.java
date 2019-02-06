package com.biss.demo.Budget2.controller;

import com.biss.demo.Budget2.dto.HardwareDetailsDto;
import com.biss.demo.Budget2.dto.HardwareTypeDto;
import com.biss.demo.Budget2.model.Hardware;
import com.biss.demo.Budget2.model.HardwareType;
import com.biss.demo.Budget2.repository.HardwareJpaRepository;
import com.biss.demo.Budget2.repository.HardwareTypeJpaRepository;
import com.biss.demo.Budget2.service.HardwareTypeDtoService;
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
    private final HardwareTypeJpaRepository hardwareTypeJpaRepository;
    private final HardwareJpaRepository hardwareJpaRepository;

    @Autowired
    public HardwareTypeController(HardwareTypeJpaRepository jpaRepository, ConversionService conversionService, HardwareTypeDtoService hardwareTypeDtoService, HardwareTypeJpaRepository hardwareTypeJpaRepository, HardwareJpaRepository hardwareJpaRepository) {
        this.jpaRepository = jpaRepository;
        this.conversionService = conversionService;
        this.hardwareTypeDtoService = hardwareTypeDtoService;
        this.hardwareTypeJpaRepository = hardwareTypeJpaRepository;
        this.hardwareJpaRepository = hardwareJpaRepository;
    }

    @PostMapping(value = "/post/")
    public HardwareType save(@RequestBody HardwareTypeDto newHardwareType) {
        return jpaRepository.save(conversionService.convert(newHardwareType, HardwareType.class));
    }

    @GetMapping(value = "/all")
    public List<HardwareTypeDto> findAll() {
        return hardwareTypeDtoService.findAll();
    }

    @GetMapping(value = "/type/{type}")
    public List<HardwareTypeDto> findAllByType(final @PathVariable String type){
        List<HardwareTypeDto> hardwareTypeDtoList = (List<HardwareTypeDto>) conversionService.convert(jpaRepository.findHardwareTypeIdByType(type), TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(HardwareType.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(HardwareTypeDto.class)));
        return hardwareTypeDtoList;
    }

    @GetMapping (value = "/hardwareType/{hardwareType}")
    public List<HardwareDetailsDto> findAllByHardwareType(final @PathVariable String hardwareType)
    {
        return (List<HardwareDetailsDto>) conversionService.convert(hardwareJpaRepository.findAllByHardwareType_Type(hardwareType), TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Hardware.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(HardwareDetailsDto.class)));
    }

}



