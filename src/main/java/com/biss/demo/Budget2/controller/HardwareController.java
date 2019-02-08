package com.biss.demo.Budget2.controller;

import com.biss.demo.Budget2.dto.HardwareDetailsDto;
import com.biss.demo.Budget2.repository.HardwareJpaRepository;
import com.biss.demo.Budget2.service.HardwareDetailsService;
import com.biss.demo.Budget2.service.impl.HardwareDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/hardwares")
public class HardwareController {

    private final HardwareJpaRepository hardwareJpaRepository;
    private final ConversionService conversionService;
    private final HardwareDetailsServiceImpl hardwareDetailsService;

    @Autowired
    public HardwareController(HardwareJpaRepository hardwareJpaRepository, ConversionService conversionService, HardwareDetailsServiceImpl hardwareDetailsService) {
        this.hardwareJpaRepository = hardwareJpaRepository;
        this.conversionService = conversionService;
        this.hardwareDetailsService = hardwareDetailsService;
    }

    @PostMapping(value = "/post")
    public HardwareDetailsDto save(@RequestBody HardwareDetailsDto hardwareDetailsDto) {
        return hardwareDetailsService.save(hardwareDetailsDto);
    }

    @DeleteMapping(value = "/id/{id}")
    public void delete(@PathVariable("id") Long id) {
        hardwareJpaRepository.deleteById(id);
    }

    @GetMapping(value = "/all")
    public List<HardwareDetailsDto> findAll() {
        return hardwareDetailsService.findAll();
    }

    @GetMapping(value = "/hardwareTypeId/{hardwareTypeId}")
    public List<HardwareDetailsDto> findAllByHardwareTypeId(final @PathVariable Long hardwareTypeId) {
        return hardwareDetailsService.findAllByHardwareType_Id(hardwareTypeId);
    }

    @GetMapping(value = "/hardwareType/{hardwareType}")
    public List<HardwareDetailsDto> findAllByType_type(final @PathVariable String hardwareType) {
        return hardwareDetailsService.findByHardwareType_Type(hardwareType);

    }

    @GetMapping(value = "/test/{id}")
    public  HardwareDetailsDto test(final @PathVariable Long id){
        return hardwareDetailsService.findHardwareById(id);
    }

}