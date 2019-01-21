package com.biss.demo.Budget2.controller;

import com.biss.demo.Budget2.dto.PositionDto;
import com.biss.demo.Budget2.model.Position;
import com.biss.demo.Budget2.repository.PositionJpaRepository;
import com.biss.demo.Budget2.service.PositionDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/positions")
public class PositionController {

    private final PositionJpaRepository jpaRepository;
    private final ConversionService conversionService;
    private final PositionDtoService positionDtoService;


    @Autowired
    public PositionController(PositionJpaRepository jpaRepository, ConversionService conversionService, PositionDtoService positionDtoService) {
        this.jpaRepository = jpaRepository;
        this.conversionService = conversionService;
        this.positionDtoService = positionDtoService;
    }
    @PostMapping(value = "/post/")
    public Position savePosition(@RequestBody Position newPosition) {
        return positionDtoService.save(newPosition);
    }

    @GetMapping(value = "/id/{id}")
    public PositionDto getPositionByid(final @PathVariable("id") Long id) {
        return positionDtoService.findPositionById(id);
    }
    @GetMapping(value = "/{position}")
    public PositionDto getPositionByName(final @PathVariable("position") String position) {
        return positionDtoService.findPositionByPosition(position);
    }

    @GetMapping(value = "/all")
    public PositionDto getAll(final @PathVariable("all") Long id){
        return (PositionDto) positionDtoService.findAll(id);
    }
}

//    @GetMapping (value = "/id/{id}")
//    public PersonDetailsDto findById(final @PathVariable("id") Long id){
//        return personDetailsService.findPersonDetailsByPersonId(id);
//    }
//
//    @GetMapping (value = "/userName/{userName}")
//    public PersonDetailsDto findByUserName(final @PathVariable("userName") String userName){
//        return personDetailsService.findPersonByUserName(userName);