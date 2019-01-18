package com.biss.demo.Budget2.controller;

import com.biss.demo.Budget2.dto.PositionDto;
import com.biss.demo.Budget2.model.Position;
import com.biss.demo.Budget2.repository.PositionJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/positions")
public class PositionController {

    private final PositionJpaRepository jpaRepository;
    private final ConversionService conversionService;


    @Autowired
    public PositionController(PositionJpaRepository jpaRepository, ConversionService conversionService) {
        this.jpaRepository = jpaRepository;
        this.conversionService = conversionService;
    }
    @PostMapping(value = "/post/")
    public Position savePosition(@RequestBody PositionDto newPosition) {
        return jpaRepository.save(conversionService.convert(newPosition, Position.class));
    }

    @GetMapping(value = "/id/{id}")
    public PositionDto getPositionDto(final @PathVariable("id") Long id) {
        return conversionService.convert(jpaRepository.getOne(id), PositionDto.class);
    }

}

