package com.biss.demo.Budget2.service;

import com.biss.demo.Budget2.dto.PersonDetailsDto;

public interface PersonDetailsService {

    PersonDetailsDto findPersonByUserName(String userName);

    PersonDetailsDto findPersonDetailsByPersonId(Long id);

    PersonDetailsDto save(PersonDetailsDto personDetailsDto);
}
