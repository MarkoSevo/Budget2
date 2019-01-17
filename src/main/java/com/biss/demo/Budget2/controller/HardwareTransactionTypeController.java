package com.biss.demo.Budget2.controller;

import com.biss.demo.Budget2.model.HardwareTransactionType;
import com.biss.demo.Budget2.repository.HardwareTransactionTypeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/hardwaretransactiontypes")
public class HardwareTransactionTypeController {

    private final HardwareTransactionTypeJpaRepository jpaRepository;

    @Autowired
    public HardwareTransactionTypeController(HardwareTransactionTypeJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @GetMapping(value = "id/{id}")
    public HardwareTransactionType findHardwareTransactionTypeById(final @PathVariable("id") Long id) {
        return jpaRepository.findHardwareTransactionTypeById(id);
    }
    @GetMapping(value = "/all")
    public List<HardwareTransactionType> allHardwareTransactionTypes() {
        return jpaRepository.findAll();
    }
}



