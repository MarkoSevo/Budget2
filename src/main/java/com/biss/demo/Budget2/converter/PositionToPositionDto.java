package com.biss.demo.Budget2.converter;

import com.biss.demo.Budget2.dto.PositionDto;
import com.biss.demo.Budget2.model.Position;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PositionToPositionDto implements Converter<Position, PositionDto> {
    @Override
    public PositionDto convert(Position source) {
        return new PositionDto(source.getId(),source.getPosition(),source.getId());
    }
}
