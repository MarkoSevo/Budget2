package com.biss.demo.Budget2.converter;

import com.biss.demo.Budget2.dto.PersonDetailsDto;
import com.biss.demo.Budget2.model.Person;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class PersonToPersonDetailsDtoConverter implements Converter<Person, PersonDetailsDto> {

    @Override
    public PersonDetailsDto convert(Person source) {
        return new PersonDetailsDto(source.getId(),source.getFirstName(),source.getLastName(),source.getEmail(),source.getUserName(),null);
    }
}
