package com.biss.demo.Budget2.controller;


import com.biss.demo.Budget2.model.PersonPosition;
import com.biss.demo.Budget2.repository.PersonPositionJpaRepository;
import com.biss.demo.Budget2.service.impl.PersonPositionDtoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personpositions")
public class PersonPositionController {

    private final PersonPositionJpaRepository jpaRepository;
    private final PersonPositionDtoServiceImpl peronPositionDtoService;

    @Autowired
    PersonPositionController(PersonPositionJpaRepository jpaRepository, PersonPositionDtoServiceImpl peronPositionDtoService) {
        this.jpaRepository = jpaRepository;
        this.peronPositionDtoService = peronPositionDtoService;
    }

    @GetMapping(value = "/all")
    public List<PersonPosition> all() {
        return jpaRepository.findAll();
    }

}
