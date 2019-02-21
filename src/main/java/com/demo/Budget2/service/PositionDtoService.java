package com.demo.Budget2.service;

import com.demo.Budget2.dto.PositionDto;

import java.util.List;

public interface PositionDtoService {


    PositionDto findPositionByPosition (String positionName);

    PositionDto findPositionById (Long id);

    List<PositionDto> findAll ();

    PositionDto save(PositionDto positionDto);
}
