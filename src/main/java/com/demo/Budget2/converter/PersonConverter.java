package com.demo.Budget2.converter;

import com.demo.Budget2.dto.GetPersonDto;
import com.demo.Budget2.dto.PersonDetailsDto;
import com.demo.Budget2.model.Person;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

public class PersonConverter {

    @Component
    public static class PersonToPersonDetailsDto implements Converter<Person, PersonDetailsDto> {

        @Override
        public PersonDetailsDto convert(Person source) {
            return new PersonDetailsDto(source.getId(), source.getFirstName(),source.getLastName(),source.getEmail(),source.getUserName(),null);
        }
    }

    @Component
    public static class PersonToGetPersonDto implements Converter<Person, GetPersonDto> {
        @Override
        public GetPersonDto convert(Person source) {
            return new GetPersonDto(source.getId(),source.getFirstName(),source.getLastName(),source.getEmail(),source.getUserName(),
                    null,null,null);
        }
    }

    @Component
    public static class PersonDetailsDtoToPerson implements Converter<PersonDetailsDto, Person> {

        @Override
        public Person convert(PersonDetailsDto source) {
            return new Person(source.getId(),null, source.getFirstName(),source.getLastName(),source.getEmail(),
                    source.getUserName(),null,null,null);
        }
    }

    @Component
    public static class GetPersonDtoToPerson implements Converter<GetPersonDto, Person> {
        @Override
        public Person convert(GetPersonDto source) {
            return new Person(source.getId(),null,source.getFirstName(),source.getLastName(),source.getLastName(),source.getUserName(),
                    null,null,null);
        }
    }
}
