package com.demo.Budget2.controller;

import com.demo.Budget2.dto.HardwareDetailsDto;
import com.demo.Budget2.service.impl.HardwareDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/hardwares")
public class HardwareController {

    private final HardwareDetailsServiceImpl hardwareDetailsService;

    @Autowired
    public HardwareController(HardwareDetailsServiceImpl hardwareDetailsService) {
        this.hardwareDetailsService = hardwareDetailsService;
    }

    @PostMapping(value = "/post")
    public HardwareDetailsDto save(@RequestBody HardwareDetailsDto hardwareDetailsDto) {
        return hardwareDetailsService.save(hardwareDetailsDto);
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
    public List<HardwareDetailsDto> findAllByType_Type(final @PathVariable String hardwareType) {
        return hardwareDetailsService.findByHardwareType_Type(hardwareType);

    }

    @GetMapping(value = "/test/{id}")
    public HardwareDetailsDto test(final @PathVariable Long id){
        return hardwareDetailsService.findHardwareById(id);
    }

}