//package com.biss.demo.Budget2.controller;
//
//
//import com.biss.demo.Budget2.model.PersonPosition;
//import com.biss.demo.Budget2.repository.PersonPositionJpaRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/personpositions")
//public class PersonPositionController {
//
//    private final PersonPositionJpaRepository jpaRepository;
//
//    @Autowired
//    PersonPositionController(PersonPositionJpaRepository jpaRepository) {
//        this.jpaRepository = jpaRepository;
//    }
//
//    @PostMapping(value = "/post")
//    public PersonPosition save(@RequestBody PersonPosition personPosition){
//        return jpaRepository.save(personPosition);
//    }
//
//    @GetMapping(value = "/all")
//    public List<PersonPosition> all() {
//        return jpaRepository.findAll();
//    }
//
//}
