package com.biss.demo.Budget2.controller;

import com.biss.demo.Budget2.dto.PersonDetailsDto;
import com.biss.demo.Budget2.service.PersonDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persondetails")
public class PersonDetailsController {

    private final PersonDetailsService personDetailsService;


    public PersonDetailsController(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    @PostMapping(value = "/post/")
    public PersonDetailsDto save(@RequestBody PersonDetailsDto newPerson) {
        newPerson.setFirstName(newPerson.getFirstName());
        newPerson.setLastName(newPerson.getLastName());
        newPerson.setEmail(newPerson.getEmail());
        newPerson.setUserName(newPerson.getUserName());
        newPerson.setPosition(newPerson.getPosition());
        personDetailsService.save(newPerson);
        return newPerson;
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
}
