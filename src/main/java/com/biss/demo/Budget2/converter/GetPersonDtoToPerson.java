package com.biss.demo.Budget2.converter;

import com.biss.demo.Budget2.dto.GetPersonDto;
import com.biss.demo.Budget2.model.Person;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GetPersonDtoToPerson implements Converter<GetPersonDto, Person> {
    @Override
    public Person convert(GetPersonDto source) {
        return new Person(source.getId(),null,source.getFirstName(),source.getLastName(),source.getLastName(),source.getUserName(),
                null,null,null);
    }
}
