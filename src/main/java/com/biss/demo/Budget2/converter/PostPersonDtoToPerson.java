//package com.biss.demo.Budget2.converter;
//
//import com.biss.demo.Budget2.dto.PersonDetailsDto;
//import com.biss.demo.Budget2.dto.PostPersonDto;
//import com.biss.demo.Budget2.model.Person;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.stereotype.Component;
//
//@Component
//public class PostPersonDtoToPerson implements Converter<PostPersonDto, Person> {
//    @Override
//    public Person convert(PostPersonDto source) {
//        return new Person(source.getId(),source.getVersion(),source.getFirstName(),source.getLastName(),source.getEmail(),source.getUserName(),null,null,null);
//    }
//}
