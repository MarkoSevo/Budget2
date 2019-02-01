package com.biss.demo.Budget2.converter;

import com.biss.demo.Budget2.dto.GetPersonDto;
import com.biss.demo.Budget2.model.Person;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonToGetPersonDto implements Converter<Person, GetPersonDto> {
    @Override
    public GetPersonDto convert(Person source) {
        return new GetPersonDto(source.getId(),source.getFirstName(),source.getLastName(),source.getEmail(),source.getUserName(),
                null,null,null,null);
    }
}
