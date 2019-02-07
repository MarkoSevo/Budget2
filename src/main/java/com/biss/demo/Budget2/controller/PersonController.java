package com.biss.demo.Budget2.controller;

import com.biss.demo.Budget2.dto.*;
import com.biss.demo.Budget2.model.HardwareBudgetTransaction;
import com.biss.demo.Budget2.model.Person;
import com.biss.demo.Budget2.repository.HardwareBudgetTransactionRepository;
import com.biss.demo.Budget2.service.impl.PersonDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonDetailsServiceImpl personDetailsService;
    private final ConversionService conversionService;
    private final HardwareBudgetTransactionRepository hardwareBudgetTransactionRepository;
    @Autowired
    PersonController(PersonDetailsServiceImpl personDetailsService, ConversionService conversionService, HardwareBudgetTransactionRepository hardwareBudgetTransactionRepository) {

        this.personDetailsService = personDetailsService;
        this.conversionService = conversionService;
        this.hardwareBudgetTransactionRepository = hardwareBudgetTransactionRepository;

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

    @GetMapping(value = "/test/{id}")
    public List<HardwareBudgetTransactionDto> test(final @PathVariable Long id){
        return (List<HardwareBudgetTransactionDto>) conversionService.convert(hardwareBudgetTransactionRepository.findAllByBudgetTransaction_Person_Id(id), TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(HardwareBudgetTransaction.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(HardwareBudgetTransactionDto.class)));
    }
}
