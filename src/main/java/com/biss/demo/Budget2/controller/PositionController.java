package com.biss.demo.Budget2.controller;

import com.biss.demo.Budget2.dto.PositionDto;
import com.biss.demo.Budget2.model.Position;
import com.biss.demo.Budget2.repository.PositionJpaRepository;
import com.biss.demo.Budget2.service.PositionDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/positions")
public class PositionController {

    private final PositionJpaRepository positionJpaRepository;
    private final ConversionService conversionService;
    private final PositionDtoService positionDtoService;


    @Autowired
    public PositionController(PositionJpaRepository positionJpaRepository, ConversionService conversionService, PositionDtoService positionDtoService) {
        this.positionJpaRepository = positionJpaRepository;
        this.conversionService = conversionService;
        this.positionDtoService = positionDtoService;
    }

    @PostMapping(value = "/post/")
    public Position savePosition(@RequestBody Position newPosition) {
        return positionDtoService.save(newPosition);
    }

    @GetMapping(value = "/id/{id}")
    public PositionDto getPositionById(final @PathVariable("id") Long id) {
        return positionDtoService.findPositionById(id);
    }

    @GetMapping(value = "/{position}")
    public PositionDto getPositionByName(final @PathVariable("position") String position) {
        return positionDtoService.findPositionByPosition(position);
    }

    @GetMapping(value = "/all")
    public List<PositionDto> findAll() {
        return positionDtoService.findAll();
    }
}
