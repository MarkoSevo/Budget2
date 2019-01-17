//package com.biss.demo.Budget2.controller;
//
//
//import com.biss.demo.Budget2.model.PersonPosition;
//import com.biss.demo.Budget2.repository.PersonPositionJpaRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
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
//    @GetMapping(value = "/all")
//    public List<PersonPosition> all() {
//        return jpaRepository.findAll();
//    }
//
//    @GetMapping (value = "/positions/{personid}")
//    public PersonPosition findAllByPositionId(@PathVariable("personid") Long personid) {
//        return jpaRepository.findAllByPositionId(personid);
//    }
//
//    @GetMapping (value = "/persons/{positionid}")
//    public PersonPosition findAllByPersonId(@PathVariable("positionid") Long positionid) {
//        return jpaRepository.findAllByPersonId(positionid);
//    }
//}
