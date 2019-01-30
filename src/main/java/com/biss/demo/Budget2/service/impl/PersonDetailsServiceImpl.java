package com.biss.demo.Budget2.service.impl;

import com.biss.demo.Budget2.dto.PersonDetailsDto;
import com.biss.demo.Budget2.dto.PositionDto;
import com.biss.demo.Budget2.model.*;
import com.biss.demo.Budget2.repository.*;
import com.biss.demo.Budget2.service.PersonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;


@Service
public class PersonDetailsServiceImpl implements PersonDetailsService {

    private final BudgetJpaRepository budgetJpaRepository;
    private final PersonJpaRepository personJpaRepository;
    private final HardwareJpaRepository hardwareJpaRepository;
    private final PositionJpaRepository positionJpaRepository;
    private final HardwareTransactionJpaRepository hardwareTransactionJpaRepository;
    private final ConversionService conversionService;
    private final PersonPositionJpaRepository personPositionJpaRepository;
    private final BudgetPositionJpaRepository budgetPositionJpaRepository;

    @Autowired
    public PersonDetailsServiceImpl(BudgetJpaRepository budgetJpaRepository, PersonJpaRepository personJpaRepository, HardwareJpaRepository hardwareJpaRepository, PositionJpaRepository positionJpaRepository, HardwareTransactionJpaRepository hardwareTransactionJpaRepository, ConversionService conversionService, PersonPositionJpaRepository personPositionJpaRepository, BudgetPositionJpaRepository budgetPositionJpaRepository) {
        this.budgetJpaRepository = budgetJpaRepository;
        this.personJpaRepository = personJpaRepository;
        this.hardwareJpaRepository = hardwareJpaRepository;
        this.positionJpaRepository = positionJpaRepository;
        this.hardwareTransactionJpaRepository = hardwareTransactionJpaRepository;
        this.conversionService = conversionService;
        this.personPositionJpaRepository = personPositionJpaRepository;
        this.budgetPositionJpaRepository = budgetPositionJpaRepository;
    }

    @Override
    public PersonDetailsDto findPersonByUserName(String username) {
        Person person = personJpaRepository.findPersonByUserName(username);
        PersonDetailsDto dto = new PersonDetailsDto();
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setEmail(person.getEmail());
        dto.setUserName(person.getUserName());
        return dto;
    }

    @Override
    public PersonDetailsDto findPersonDetailsByPersonId(Long id) {
        Person person = personJpaRepository.getOne(id);
        PersonDetailsDto dto = new PersonDetailsDto();
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setEmail(person.getEmail());
        dto.setUserName(person.getUserName());
        return dto;
    }

    @Override
    public PersonDetailsDto save(PersonDetailsDto personDetailsDto){
        Person person = conversionService.convert(personDetailsDto, Person.class);
        personJpaRepository.save(person);
        return personDetailsDto;
    }
}
