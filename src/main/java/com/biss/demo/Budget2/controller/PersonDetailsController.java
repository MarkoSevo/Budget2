package com.biss.demo.Budget2.controller;

import com.biss.demo.Budget2.dto.PersonDetailsDto;
import com.biss.demo.Budget2.service.MyFirstService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persondetails")
public class PersonDetailsController {

    private final MyFirstService myFirstService;


    public PersonDetailsController(MyFirstService myFirstService) {
        this.myFirstService = myFirstService;
    }

    @GetMapping (value = "/id/{id}")
    public PersonDetailsDto findById(final @PathVariable("id") Long id){
        return myFirstService.findPersonDetailsByPersonId(id);
    }

    @GetMapping (value = "/userName/{userName}")
    public PersonDetailsDto findByUserName(final @PathVariable("userName") String userName){
        return myFirstService.findPersonByUserName(userName);
    }

    @GetMapping (value = "/hardwareid/{hardwareid}")
    public PersonDetailsDto findByHardwareId(final @PathVariable("hardwareid") Long hardwareid){
        return myFirstService.findHardwareById(hardwareid);
    }
}
