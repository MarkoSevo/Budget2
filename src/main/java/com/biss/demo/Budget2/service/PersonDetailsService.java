package com.biss.demo.Budget2.service;

import com.biss.demo.Budget2.dto.PersonDetailsDto;

import java.util.List;

public interface PersonDetailsService {

    PersonDetailsDto findPersonByUserName(String userName);

    PersonDetailsDto findHardwareById(Long id);

    PersonDetailsDto findPersonDetailsByPersonId(Long id);
}
