//package com.biss.demo.Budget2.converter;
//
//import com.biss.demo.Budget2.dto.PostPersonDto;
//import com.biss.demo.Budget2.model.Person;
//import org.springframework.core.convert.converter.Converter;
//
//public class PersonToPostPersonDto implements Converter<Person, PostPersonDto> {
//    @Override
//    public PostPersonDto convert(Person source) {
//        return new PostPersonDto(source.getId(),source.getVersion(),source.getFirstName(),source.getLastName(),source.getEmail(),source.getUserName(),null);
//    }
//}
