package com.biss.demo.Budget2.converter;

import com.biss.demo.Budget2.dto.PositionDto;
import com.biss.demo.Budget2.model.Position;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PositionDtoToPosition implements Converter<PositionDto, Position> {
    @Override
    public Position convert(PositionDto source) {
        return new Position(source.getId(),null, source.getPosition());
    }
}
