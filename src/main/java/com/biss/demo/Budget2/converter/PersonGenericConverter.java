//package com.biss.demo.Budget2.converter;
//
//import com.biss.demo.Budget2.dto.PersonDetailsDto;
//import com.biss.demo.Budget2.dto.PersonDto;
//import com.biss.demo.Budget2.model.Budget;
//import com.biss.demo.Budget2.model.BudgetTransaction;
//import com.biss.demo.Budget2.model.Person;
//import org.springframework.core.convert.TypeDescriptor;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.core.convert.converter.GenericConverter;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.Set;
//
//@Component
//public class PersonGenericConverter {
//
//    @Component
//    public static class PersonToPersonDetailsDto implements Converter<Person, PersonDto>{
//        @Override
//        public PersonDto convert(Person source) {
//            return new PersonDto(source.getId(),source.getVersion(),source.getFirstName(),source.getLastName(),source.getEmail(),null,source.getHardwareTransaction(),null);
//        }
//        @Component
//        public static class BudgetToPersonDetailsDto implements Converter<Budget, PersonDto>{
//
//            @Override
//            public PersonDto convert(Budget source) {
//                return new PersonDto(null,null,null,null,null, (List<BudgetTransaction>) source.getAmount(),null,null);
//            }
//        }
//    }
//
//}
