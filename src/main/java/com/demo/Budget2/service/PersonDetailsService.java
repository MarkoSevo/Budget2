package com.demo.Budget2.service;

import com.demo.Budget2.dto.GetPersonDto;
import com.demo.Budget2.dto.PersonDetailsDto;

public interface PersonDetailsService {

    GetPersonDto findPersonByUserName(String userName);

    GetPersonDto findPersonDetailsByPersonId(Long id);

    PersonDetailsDto save(PersonDetailsDto personDetailsDto);
}
