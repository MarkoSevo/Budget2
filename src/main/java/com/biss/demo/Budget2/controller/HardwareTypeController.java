package com.biss.demo.Budget2.controller;

import com.biss.demo.Budget2.dto.HardwareTypeDto;
import com.biss.demo.Budget2.model.HardwareType;
import com.biss.demo.Budget2.repository.HardwareTypeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/hardwaretypes")
public class HardwareTypeController {

    private final HardwareTypeJpaRepository jpaRepository;
    private final ConversionService conversionService;

    @Autowired
    public HardwareTypeController(HardwareTypeJpaRepository jpaRepository, ConversionService conversionService) {
        this.jpaRepository = jpaRepository;
        this.conversionService = conversionService;
    }

    @PostMapping (value = "/post/")
    public HardwareType save(@RequestBody HardwareTypeDto newHardwareType){
        return jpaRepository.save(conversionService.convert(newHardwareType, HardwareType.class));
    }

    @GetMapping (value = "/id/{id}")
    public HardwareTypeDto getHardwareDto(final @PathVariable("id") Long id){
        return conversionService.convert(jpaRepository.getOne(id), HardwareTypeDto.class);
    }
    @GetMapping (value = "/type/{type}")
    public HardwareTypeDto getHardwareDto(final @PathVariable("type") String type){
        return conversionService.convert(jpaRepository.findAllByType(type), HardwareTypeDto.class);
    }

}


