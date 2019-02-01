package com.biss.demo.Budget2.converter;

import com.biss.demo.Budget2.dto.PersonDetailsDto;
import com.biss.demo.Budget2.model.Person;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class PersonDetailsDtoToPersonConverter implements Converter<PersonDetailsDto, Person> {

    @Override
    public Person convert(PersonDetailsDto source) {
        return new Person(source.getIdDto(),null, source.getFirstName(),source.getLastName(),source.getEmail(), source.getUserName(),null,null,null);
    }
}
