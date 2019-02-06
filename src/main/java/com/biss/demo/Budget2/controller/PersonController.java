package com.biss.demo.Budget2.controller;

import com.biss.demo.Budget2.dto.*;
import com.biss.demo.Budget2.repository.HardwareTransactionJpaRepository;
import com.biss.demo.Budget2.repository.PersonJpaRepository;
import com.biss.demo.Budget2.service.HardwareTransactionDtoService;
import com.biss.demo.Budget2.service.impl.PersonDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonJpaRepository personJpaRepository;
    private final ConversionService conversionService;
    private final PersonDetailsServiceImpl personDetailsService;
    private final HardwareTransactionDtoService hardwareTransactionDtoService;
    private final HardwareTransactionJpaRepository hardwareTransactionJpaRepository;

    @Autowired
    PersonController(PersonJpaRepository personJpaRepository, ConversionService conversionService, PersonDetailsServiceImpl personDetailsService, HardwareTransactionDtoService hardwareTransactionDtoService, HardwareTransactionJpaRepository hardwareTransactionJpaRepository) {
        this.personJpaRepository = personJpaRepository;
        this.conversionService = conversionService;
        this.personDetailsService = personDetailsService;
        this.hardwareTransactionDtoService = hardwareTransactionDtoService;
        this.hardwareTransactionJpaRepository = hardwareTransactionJpaRepository;
    }

    @PostMapping(value = "/post/")
    public PersonDetailsDto save(@RequestBody PersonDetailsDto personDetailsDto) {
        return personDetailsService.save(personDetailsDto);
    }

    @GetMapping(value = "/userName/{username}")
    public GetPersonDto getPersonDetailsByUsername(final @PathVariable String username) {
        return personDetailsService.findPersonByUserName(username);
    }


    @GetMapping(value = "/id/{id}")
    public GetPersonDto getPersonDetailsDtoById(final @PathVariable Long id) {
        return personDetailsService.findPersonDetailsByPersonId(id);
    }
}
