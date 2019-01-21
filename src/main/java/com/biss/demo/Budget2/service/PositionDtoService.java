package com.biss.demo.Budget2.service;

import com.biss.demo.Budget2.dto.PositionDto;
import com.biss.demo.Budget2.model.Position;
import java.util.List;

public interface PositionDtoService {


    PositionDto findPositionByPosition (String positionName);

    PositionDto findPositionById (Long id);

    List<PositionDto> findAll (Long position);

    Position save(Position newPosition);

}
