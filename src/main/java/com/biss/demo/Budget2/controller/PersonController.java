package com.biss.demo.Budget2.controller;

import com.biss.demo.Budget2.dto.*;
import com.biss.demo.Budget2.model.HardwareTransaction;
import com.biss.demo.Budget2.repository.HardwareTransactionJpaRepository;
import com.biss.demo.Budget2.repository.PersonJpaRepository;
import com.biss.demo.Budget2.service.HardwareTransactionDtoService;
import com.biss.demo.Budget2.service.impl.PersonDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @GetMapping (value = "/userName/{username}")
    public GetPersonDto getPersonDetailsByUsername(final @PathVariable String username){
        return personDetailsService.findPersonByUserName(username);
    }


    @GetMapping (value = "/id/{id}")
    public GetPersonDto getPersonDetailsDtoById(final @PathVariable Long id){
        return personDetailsService.findPersonDetailsByPersonId(id);
    }

    @GetMapping (value = "/hardware/personId/")
    public List<HardwareTransactionDto> getHardwareTransactionByPersonId(){
        return hardwareTransactionDtoService.getAllByPersonId();
    }

//    @GetMapping(value = "/id/{id}")
//    public PersonDetailsDto getPersonDto(final @PathVariable("id") Long id) {
//        return conversionService.convert(jpaRepository.getOne(id), PersonDetailsDto.class);
//    }
//
//    @GetMapping (value = "/userName/{userName}")
//    public PersonDetailsDto findPersonByUserName(final @PathVariable String userName){
//        return conversionService.convert(jpaRepository.findPersonByUserName(userName), PersonDetailsDto.class);
//    }

}
//    @GetMapping(value = "/firstName/{firstName}")
//    public PersonDetailsDto findPersonByFirstName(final @PathVariable("firstName") String firstName) {
//        return conversionService.convert(jpaRepository.findPersonByFirstName(firstName), PersonDetailsDto.class);
//    }
//
//    @GetMapping(value = "/lastName/{lastName}")
//    public PersonDetailsDto findPersonByLastName(final @PathVariable("lastName") String lastName){
//       return conversionService.convert(jpaRepository.findPersonByLastName(lastName), PersonDetailsDto.class);
//    }
//
//    @GetMapping (value = "/firstName/lastName/{firstName}/{lastName}")
//    public PersonDetailsDto findPersonByFullName(final @PathVariable String firstName, final @PathVariable String lastName){
//        return conversionService.convert(jpaRepository.findPersonByFirstNameAndLastName(firstName, lastName), PersonDetailsDto.class);
//    }
//

//
//    @GetMapping (value = "/email/{email}")
//    public PersonDetailsDto findPersonByEmail (final @PathVariable String email){
//        return conversionService.convert(jpaRepository.findPersonByEmail(email), PersonDetailsDto.class);
//    }
//
////    @DeleteMapping(value = "/id/{id}")
////    public void delete(final @PathVariable("id") Long id) {
////        jpaRepository.deleteById(id);
////    }
//
//    @GetMapping(value = "/all")
//    public List<PersonDetailsDto> findALL() {
//        return (List<PersonDetailsDto>) conversionService.convert(jpaRepository.findAll(), TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Person.class)),
//                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(PersonDetailsDto.class)));
//    }
//
//}
//
////    @GetMapping (value = "/all")
////    public PersonDto findAll(){
////        return conversionService.convert(jpaRepository.findAll(), PersonDto.class);
////    }