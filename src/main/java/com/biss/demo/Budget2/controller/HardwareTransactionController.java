package com.biss.demo.Budget2.controller;

import com.biss.demo.Budget2.dto.HardwareTransactionDto;
import com.biss.demo.Budget2.model.HardwareTransaction;
import com.biss.demo.Budget2.repository.HardwareTransactionJpaRepository;
import com.biss.demo.Budget2.service.impl.HardwareTransactionDtoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/hardwaretransactions")
public class HardwareTransactionController {

    private final HardwareTransactionJpaRepository jpaRepository;
    private final ConversionService conversionService;
    private final HardwareTransactionDtoServiceImpl hardwareTransactionDtoService;


    @Autowired
    public HardwareTransactionController(HardwareTransactionJpaRepository jpaRepository, ConversionService conversionService, HardwareTransactionDtoServiceImpl hardwareTransactionDtoService) {
        this.jpaRepository = jpaRepository;
        this.conversionService = conversionService;
        this.hardwareTransactionDtoService = hardwareTransactionDtoService;
    }

    @PostMapping (value = "/post/")
    public HardwareTransactionDto save(@RequestBody HardwareTransactionDto newHardwareTransaction){
        return hardwareTransactionDtoService.save(newHardwareTransaction);
    }

}
//    @GetMapping (value = "/id/{id}")
//    public HardwareTransactionDto getHardwareTransactionDto(final @PathVariable("id") Long id){
//        return conversionService.convert(jpaRepository.getOne(id), HardwareTransactionDto.class);
//    }




