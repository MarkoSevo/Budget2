package com.biss.demo.Budget2.service;

import com.biss.demo.Budget2.dto.PersonDetailsDto;
import com.biss.demo.Budget2.model.Person;

public interface PersonDetailsService {

    PersonDetailsDto findPersonByUserName(String userName);

    PersonDetailsDto findHardwareById(Long id);

    PersonDetailsDto findPersonDetailsByPersonId(Long id);

    Person save(PersonDetailsDto personDetailsDto);
}
