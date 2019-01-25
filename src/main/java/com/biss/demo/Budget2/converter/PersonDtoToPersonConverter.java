package com.biss.demo.Budget2.converter;

        import com.biss.demo.Budget2.dto.PersonDto;
        import com.biss.demo.Budget2.model.Person;
        import org.springframework.core.convert.converter.Converter;
        import org.springframework.stereotype.Component;

@Component
public class PersonDtoToPersonConverter implements Converter<PersonDto, Person> {
    @Override
    public Person convert(PersonDto source) {
        return new Person(source.getId(),source.getVersion(),source.getFirstName(), source.getLastName(), source.getEmail(),source.getUserName());
    }
}
