package com.biss.demo.Budget2.controller;

import com.biss.demo.Budget2.dto.HardwareDetailsDto;
import com.biss.demo.Budget2.dto.HardwareTypeDto;
import com.biss.demo.Budget2.dto.PositionDto;
import com.biss.demo.Budget2.model.Hardware;
import com.biss.demo.Budget2.model.HardwareType;
import com.biss.demo.Budget2.model.Position;
import com.biss.demo.Budget2.repository.HardwareJpaRepository;
import com.biss.demo.Budget2.service.HardwareDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/hardwares")
public class HardwareController {

    private final HardwareJpaRepository hardwareJpaRepository;
    private final ConversionService conversionService;
    private final HardwareDetailsService hardwareDetailsService;


    @Autowired
    public HardwareController(HardwareJpaRepository hardwareJpaRepository, ConversionService conversionService, HardwareDetailsService hardwareDetailsService) {
        this.hardwareJpaRepository = hardwareJpaRepository;
        this.conversionService = conversionService;
        this.hardwareDetailsService = hardwareDetailsService;
    }

    @PostMapping(value = "/post/")
    public Hardware save(@RequestBody HardwareDetailsDto newHardware) {
        return hardwareJpaRepository.save(conversionService.convert(newHardware, Hardware.class));
    }

    @DeleteMapping(value = "/id/{id}")
    public void delete(@PathVariable("id") Long id) {
        hardwareJpaRepository.deleteById(id);
    }

    @GetMapping(value = "/all")
    public List<HardwareDetailsDto> findALL() {
        return (List<HardwareDetailsDto>) conversionService.convert(hardwareJpaRepository.findAll(), TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Hardware.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(HardwareDetailsDto.class)));
    }

    @GetMapping(value = "/typeId/{typeId}")
    public List<HardwareDetailsDto> findAllByTypeId(final @PathVariable Long typeId){
        return (List<HardwareDetailsDto>) conversionService.convert(hardwareJpaRepository.findAllByHardwareType_Id(typeId), TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Hardware.class)),
                    TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(HardwareDetailsDto.class)));
        }

    @GetMapping(value = "/type/{type}")
    public List<HardwareDetailsDto> findAllByType(final @PathVariable String type){
        return (List<HardwareDetailsDto>) conversionService.convert(hardwareJpaRepository.findAllByHardwareType_Type(type), TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Hardware.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(HardwareDetailsDto.class)));
    }
}

//
//    @GetMapping(value = "/type/{type}")
//    public HardwareDetailsDto findByType(final @PathVariable("type") String hardwareType) {
//        return hardwareDetailsService.findByHardwareType(hardwareType);
//    }