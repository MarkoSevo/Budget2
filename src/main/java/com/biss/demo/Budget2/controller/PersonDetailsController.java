package com.biss.demo.Budget2.controller;

import com.biss.demo.Budget2.dto.PersonDetailsDto;
import com.biss.demo.Budget2.model.Hardware;
import com.biss.demo.Budget2.model.Person;
import com.biss.demo.Budget2.repository.PersonJpaRepository;
import com.biss.demo.Budget2.service.PersonDetailsService;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persondetails")
public class PersonDetailsController {

    private final PersonDetailsService personDetailsService;
    private final ConversionService conversionService;
    private final PersonJpaRepository personJpaRepository;

    public PersonDetailsController(PersonDetailsService personDetailsService, ConversionService conversionService, PersonJpaRepository personJpaRepository) {
        this.personDetailsService = personDetailsService;
        this.conversionService = conversionService;
        this.personJpaRepository = personJpaRepository;
    }
    @PostMapping(value = "/post/")
    public Person save(@RequestBody PersonDetailsDto newPerson) {
        return personJpaRepository.saveAndFlush(conversionService.convert(newPerson, Person.class));
    }

    @GetMapping (value = "/id/{id}")
    public PersonDetailsDto findById(final @PathVariable("id") Long id){
        return personDetailsService.findPersonDetailsByPersonId(id);
    }

    @GetMapping (value = "/userName/{userName}")
    public PersonDetailsDto findByUserName(final @PathVariable("userName") String userName){
        return personDetailsService.findPersonByUserName(userName);
    }

    @GetMapping (value = "/hardwareid/{hardwareid}")
    public PersonDetailsDto findByHardwareId(final @PathVariable("hardwareid") Long hardwareid){
        return personDetailsService.findHardwareById(hardwareid);
    }
    @GetMapping(value = "/all")
    public List<PersonDetailsDto> findALL() {
        return (List<PersonDetailsDto>) conversionService.convert(personJpaRepository.findAll(), TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Person.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(PersonDetailsDto.class)));
    }
}
