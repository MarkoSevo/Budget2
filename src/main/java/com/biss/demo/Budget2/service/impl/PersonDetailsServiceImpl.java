package com.biss.demo.Budget2.service.impl;

import com.biss.demo.Budget2.dto.GetPersonDto;
import com.biss.demo.Budget2.dto.PersonDetailsDto;
import com.biss.demo.Budget2.model.*;
import com.biss.demo.Budget2.repository.*;
import com.biss.demo.Budget2.service.PersonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import java.util.Collections;

@Service
public class PersonDetailsServiceImpl implements PersonDetailsService {

    private final BudgetJpaRepository budgetJpaRepository;
    private final PersonJpaRepository personJpaRepository;
    private final PositionJpaRepository positionJpaRepository;
    private final ConversionService conversionService;
    private final PersonPositionJpaRepository personPositionJpaRepository;
    private final BudgetTransactionServiceImpl budgetTransactionService;
    private final BudgetDtoServiceImpl budgetDtoService;
    private final BudgetTransactionJpaRepository budgetTransactionJpaRepository;


    @Autowired
    public PersonDetailsServiceImpl(BudgetJpaRepository budgetJpaRepository, PersonJpaRepository personJpaRepository, PositionJpaRepository positionJpaRepository, ConversionService conversionService, PersonPositionJpaRepository personPositionJpaRepository, BudgetTransactionServiceImpl budgetTransactionService, BudgetDtoServiceImpl budgetDtoService, BudgetTransactionJpaRepository budgetTransactionJpaRepository) {
        this.budgetJpaRepository = budgetJpaRepository;
        this.personJpaRepository = personJpaRepository;
        this.positionJpaRepository = positionJpaRepository;
        this.conversionService = conversionService;
        this.personPositionJpaRepository = personPositionJpaRepository;
        this.budgetTransactionService = budgetTransactionService;
        this.budgetDtoService = budgetDtoService;
        this.budgetTransactionJpaRepository = budgetTransactionJpaRepository;
    }

    @Override
    public GetPersonDto findPersonByUserName(String username) {
        Person person = personJpaRepository.findPersonByUserName(username);
        GetPersonDto dto = new GetPersonDto();
        GetPerson(person, dto);
        conversionService.convert(person, GetPersonDto.class);
        return dto;
    }

    @Override
    public GetPersonDto findPersonDetailsByPersonId(Long id) {
        Person person = personJpaRepository.getOne(id);
        GetPersonDto dto = new GetPersonDto();
        GetPerson(person, dto);
        conversionService.convert(person, GetPersonDto.class);
        return dto;
    }

    private void GetPerson(Person person, GetPersonDto dto) {
        dto.setId(person.getId());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setEmail(person.getEmail());
        dto.setUserName(person.getUserName());
        dto.setPosition(personPositionJpaRepository.findPersonDetailsByPersonId(String.valueOf(person.getId())));
        dto.setInitialBudget(budgetJpaRepository.findBudgetByPositionList(person.getId()));
        dto.setRemainingBudget(budgetTransactionJpaRepository.findRemainingAmount(person.getId()));
    }

    @Override
    public PersonDetailsDto save(PersonDetailsDto personDetailsDto){
        Person person = conversionService.convert(personDetailsDto, Person.class);
        person.setFirstName(person.getFirstName());
        person.setLastName(person.getLastName());
        person.setEmail(person.getEmail());
        person.setPositionList(Collections.singletonList(positionJpaRepository.getOne(personDetailsDto.getPositionId())));
        personJpaRepository.save(person);
        budgetTransactionService.saveInitialTransaction(budgetDtoService.findBudgetByPosition(personDetailsDto.getPositionId()),person.getId());
        personDetailsDto.setId(person.getId());
        return personDetailsDto;
    }
}
