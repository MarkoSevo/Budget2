package com.demo.Budget2.controller;

import com.demo.Budget2.dto.*;
import com.demo.Budget2.dto.GetPersonDto;
import com.demo.Budget2.service.impl.PersonDetailsServiceImpl;
import com.demo.Budget2.dto.PersonDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonDetailsServiceImpl personDetailsService;

    @Autowired
    PersonController(PersonDetailsServiceImpl personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    @PostMapping(value = "/post")
    public PersonDetailsDto save(@RequestBody PersonDetailsDto personDetailsDto) {
        return personDetailsService.save(personDetailsDto);
    }

    @GetMapping(value = "/userName/{username}")
    public GetPersonDto getPersonDetailsByUsername(final @PathVariable String username){
        return personDetailsService.findPersonByUserName(username);
    }

    @GetMapping(value = "/id/{id}")
    public GetPersonDto getPersonDetailsDtoById(final @PathVariable Long id) {
            return personDetailsService.findPersonDetailsByPersonId(id);
    }
}
