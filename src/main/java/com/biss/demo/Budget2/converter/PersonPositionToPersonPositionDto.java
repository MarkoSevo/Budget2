package com.biss.demo.Budget2.converter;

import com.biss.demo.Budget2.dto.PersonPositionDto;
import com.biss.demo.Budget2.model.PersonPosition;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonPositionToPersonPositionDto implements Converter<PersonPosition, PersonPositionDto> {
    @Override
    public PersonPositionDto convert(PersonPosition source) {
        return new PersonPositionDto(source.getValidFrom(),source.getValidTo(),null,null);
    }
}
