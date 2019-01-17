package com.biss.demo.Budget2.controller;

import com.biss.demo.Budget2.dto.PersonDto;
import com.biss.demo.Budget2.model.Person;
import com.biss.demo.Budget2.repository.PersonJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonJpaRepository jpaRepository;
    private final ConversionService conversionService;

    @Autowired
    PersonController(PersonJpaRepository jpaRepository, ConversionService conversionService) {
        this.jpaRepository = jpaRepository;
        this.conversionService = conversionService;
    }

    @PostMapping(value = "/post/")
    public Person save(@RequestBody PersonDto newPerson) {
        return jpaRepository.save(conversionService.convert(newPerson, Person.class));
    }

    @GetMapping(value = "/id/{id}")
    public PersonDto getPersonDto(final @PathVariable("id") Long id) {
        return conversionService.convert(jpaRepository.getOne(id), PersonDto.class);
    }

    @GetMapping(value = "/firstname/{firstName}")
    public PersonDto findPersonByFirstName(final @PathVariable("firstName") String firstName) {
        return conversionService.convert(jpaRepository.findPersonByFirstName(firstName), PersonDto.class);
    }

    @GetMapping(value = "/lastName/{lastName}")
    public PersonDto findPersonByLastName(final @PathVariable("lastName") String lastName){
       return conversionService.convert(jpaRepository.findPersonByLastName(lastName), PersonDto.class);
    }

    @GetMapping (value = "/firstName/lastName/{firstName}/{lastName}")
    public PersonDto findPersonByFullName(final @PathVariable String firstName, final @PathVariable String lastName){
        return conversionService.convert(jpaRepository.findPersonByFirstNameAndLastName(firstName, lastName), PersonDto.class);
    }

    @GetMapping (value = "/email/{email}")
    public PersonDto findPersonByEmail (final @PathVariable String email){
        return conversionService.convert(jpaRepository.findPersonByEmail(email), PersonDto.class);
    }

//    @DeleteMapping(value = "/id/{id}")
//    public void delete(final @PathVariable("id") Long id) {
//        jpaRepository.deleteById(id);
//    }

    @GetMapping(value = "/all")
    public PersonDto findAll(){
        return conversionService.convert(jpaRepository.findAll(), PersonDto.class);
    }
}

//    @GetMapping (value = "/all")
//    public PersonDto findAll(){
//        return conversionService.convert(jpaRepository.findAll(), PersonDto.class);
//    }