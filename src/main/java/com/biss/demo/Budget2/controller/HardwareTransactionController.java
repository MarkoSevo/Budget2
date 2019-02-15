package com.biss.demo.Budget2.controller;

import com.biss.demo.Budget2.dto.GetHardwareTransaction;
import com.biss.demo.Budget2.dto.HardwareTransactionDto;
import com.biss.demo.Budget2.service.impl.GetHardwareTransactionServiceImpl;
import com.biss.demo.Budget2.service.impl.HardwareTransactionDtoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/hardwaretransactions")
public class HardwareTransactionController {

    private final HardwareTransactionDtoServiceImpl hardwareTransactionDtoService;
    private final GetHardwareTransactionServiceImpl getHardwareTransactionService;

    @Autowired
    public HardwareTransactionController(HardwareTransactionDtoServiceImpl hardwareTransactionDtoService, GetHardwareTransactionServiceImpl getHardwareTransactionService) {
        this.hardwareTransactionDtoService = hardwareTransactionDtoService;
        this.getHardwareTransactionService = getHardwareTransactionService;
    }

    @PostMapping (value = "/post")
    public HardwareTransactionDto save(@RequestBody HardwareTransactionDto newHardwareTransaction){
        return hardwareTransactionDtoService.save(newHardwareTransaction);
    }

    @GetMapping (value = "/personId/{id}")
    public List<GetHardwareTransaction> findByPersonId(final @PathVariable Long id){
        return getHardwareTransactionService.findAllByPerson(id);
    }

    @GetMapping (value = "/hardwareId/{id}")
    public List<GetHardwareTransaction> findByHardwareId(final @PathVariable Long id){
        return getHardwareTransactionService.findAllByHardware(id);
    }

    @GetMapping (value = "/all")
    public List<GetHardwareTransaction> findAllTransactions(){
        return getHardwareTransactionService.findAll();
    }

}




