//package com.biss.demo.Budget2.controller;
//
//import com.biss.demo.Budget2.dto.PersonDetailsDto;
//import com.biss.demo.Budget2.model.Person;
//import com.biss.demo.Budget2.repository.PersonDetailsDtoRepository;
//import com.biss.demo.Budget2.repository.PersonJpaRepository;
//import com.biss.demo.Budget2.service.PersonDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.convert.ConversionService;
//import org.springframework.core.convert.TypeDescriptor;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/persondetails")
//public class PersonDetailsController {
//
//    private final PersonDetailsService personDetailsService;
//    private final ConversionService conversionService;
//    private final PersonJpaRepository<P, Number> personJpaRepository;
//    private final PersonDetailsDtoRepository personDetailsDtoRepository;
//
//    @Autowired
//    public PersonDetailsController(PersonDetailsService personDetailsService, ConversionService conversionService, PersonJpaRepository<P, Number> personJpaRepository, PersonDetailsDtoRepository personDetailsDtoRepository) {
//        this.personDetailsService = personDetailsService;
//        this.conversionService = conversionService;
//        this.personJpaRepository = personJpaRepository;
//        this.personDetailsDtoRepository = personDetailsDtoRepository;
//    }
//    @PostMapping(value = "/post")
//    public PersonDetailsDto save(@RequestBody Person newPerson) {
//        return personDetailsDtoRepository.saveAndFlush(conversionService.convert(newPerson, PersonDetailsDto.class));
//    }
//
//    @GetMapping (value = "/id/{id}")
//    public PersonDetailsDto findById(final @PathVariable("id") Long id){
//        return personDetailsService.findPersonDetailsByPersonId(id);
//    }
//
//    @GetMapping (value = "/userName/{userName}")
//    public PersonDetailsDto findByUserName(final @PathVariable("userName") String userName){
//        return personDetailsService.findPersonByUserName(userName);
//    }
//
//    @GetMapping (value = "/hardwareid/{hardwareid}")
//    public PersonDetailsDto findByHardwareId(final @PathVariable("hardwareid") Long hardwareid){
//        return personDetailsService.findHardwareById(hardwareid);
//    }
//    @GetMapping(value = "/all")
//    public List<PersonDetailsDto> findALL() {
//        return (List<PersonDetailsDto>) conversionService.convert(personJpaRepository.findAll(), TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Person.class)),
//                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(PersonDetailsDto.class)));
//    }
//}
