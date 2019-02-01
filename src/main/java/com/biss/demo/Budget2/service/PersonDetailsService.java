package com.biss.demo.Budget2.service;

import com.biss.demo.Budget2.dto.GetPersonDto;
import com.biss.demo.Budget2.dto.PersonDetailsDto;

public interface PersonDetailsService {

    GetPersonDto findPersonByUserName(String userName);

    GetPersonDto findPersonDetailsByPersonId(Long id);

    PersonDetailsDto save(PersonDetailsDto personDetailsDto);
}
