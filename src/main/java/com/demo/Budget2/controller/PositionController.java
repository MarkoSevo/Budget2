package com.demo.Budget2.controller;

import com.demo.Budget2.dto.PositionDto;
import com.demo.Budget2.service.PositionDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/positions")
public class PositionController {

    private final PositionDtoService positionDtoService;


    @Autowired
    public PositionController(PositionDtoService positionDtoService) {
        this.positionDtoService = positionDtoService;
    }

    @PostMapping(value = "/post")
    public PositionDto savePosition(@RequestBody PositionDto newPosition) {
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
