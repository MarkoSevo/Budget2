package com.biss.demo.Budget2.converter;

import com.biss.demo.Budget2.dto.PersonPositionDto;
import com.biss.demo.Budget2.model.PersonPosition;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonPositionDtoToPersonPosition implements Converter<PersonPositionDto, PersonPosition> {
    @Override
    public PersonPosition convert(PersonPositionDto source) {
        return new PersonPosition(source.getValidFrom(),source.getValidTo(),null, null);
    }
}
