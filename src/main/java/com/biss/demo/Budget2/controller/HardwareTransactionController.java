package com.biss.demo.Budget2.controller;

import com.biss.demo.Budget2.dto.GetHardwareTransaction;
import com.biss.demo.Budget2.dto.HardwareTransactionDto;
import com.biss.demo.Budget2.repository.HardwareTransactionJpaRepository;
import com.biss.demo.Budget2.service.impl.GetHardwareTransactionServiceImpl;
import com.biss.demo.Budget2.service.impl.HardwareTransactionDtoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/hardwaretransactions")
public class HardwareTransactionController {

    private final HardwareTransactionJpaRepository jpaRepository;
    private final ConversionService conversionService;
    private final HardwareTransactionDtoServiceImpl hardwareTransactionDtoService;
    private final GetHardwareTransactionServiceImpl getHardwareTransactionService;

    @Autowired
    public HardwareTransactionController(HardwareTransactionJpaRepository jpaRepository, ConversionService conversionService, HardwareTransactionDtoServiceImpl hardwareTransactionDtoService, GetHardwareTransactionServiceImpl getHardwareTransaction, GetHardwareTransactionServiceImpl getHardwareTransactionService) {
        this.jpaRepository = jpaRepository;
        this.conversionService = conversionService;
        this.hardwareTransactionDtoService = hardwareTransactionDtoService;
        this.getHardwareTransactionService = getHardwareTransactionService;
    }

    @PostMapping (value = "/post/")
    public HardwareTransactionDto save(@RequestBody HardwareTransactionDto newHardwareTransaction){
        return hardwareTransactionDtoService.save(newHardwareTransaction);
    }

    @GetMapping (value = "/personId/{id}")
    private List<GetHardwareTransaction> findByPersonId(final @PathVariable("id") Long id){
        return getHardwareTransactionService.findAllByPerson(id);
    }

    @GetMapping (value = "/hardwareId/{id}")
    private List<GetHardwareTransaction> findByHardwareId(final @PathVariable("id") Long id){
        return getHardwareTransactionService.findAllByHardware(id);
    }

    @GetMapping (value = "/all")
    private List<GetHardwareTransaction> findAllTransactions(){
        return getHardwareTransactionService.findAll();
    }

}




