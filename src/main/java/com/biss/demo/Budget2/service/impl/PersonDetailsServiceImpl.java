package com.biss.demo.Budget2.service.impl;

import com.biss.demo.Budget2.dto.PersonDetailsDto;
import com.biss.demo.Budget2.model.*;
import com.biss.demo.Budget2.repository.*;
import com.biss.demo.Budget2.service.PersonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PersonDetailsServiceImpl implements PersonDetailsService {

    private final BudgetJpaRepository budgetJpaRepository;
    private final PersonJpaRepository personJpaRepository;
    private final HardwareJpaRepository hardwareJpaRepository;
    private final PositionJpaRepository positionJpaRepository;
    private final BudgetPositionJpaRepository budgetPositionJpaRepository;
    private final HardwareTransactionJpaRepository hardwareTransactionJpaRepository;
    private final ConversionService conversionService;

    @Autowired
    public PersonDetailsServiceImpl(BudgetJpaRepository budgetJpaRepository, PersonJpaRepository personJpaRepository, HardwareJpaRepository hardwareJpaRepository, PositionJpaRepository positionJpaRepository, BudgetPositionJpaRepository budgetPositionJpaRepository, HardwareTransactionJpaRepository hardwareTransactionJpaRepository, ConversionService conversionService) {
        this.budgetJpaRepository = budgetJpaRepository;
        this.personJpaRepository = personJpaRepository;
        this.hardwareJpaRepository = hardwareJpaRepository;
        this.positionJpaRepository = positionJpaRepository;
        this.budgetPositionJpaRepository = budgetPositionJpaRepository;
        this.hardwareTransactionJpaRepository = hardwareTransactionJpaRepository;
        this.conversionService = conversionService;
    }

    @Override
    public PersonDetailsDto findPersonByUserName(String username) {
        Person person = personJpaRepository.findPersonByUserName(username);
        PersonDetailsDto dto = new PersonDetailsDto();
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setEmail(person.getEmail());
        dto.setUserName(person.getUserName());
        dto.setPosition(positionJpaRepository.findPersonDetailsByPersonId(String.valueOf(person.getId())));
        dto.setRemainingBudget(budgetJpaRepository.findRemainingAmount(person.getId()));
        dto.setInitialBudget(budgetPositionJpaRepository.findByPosition_Id(person.getId()));
        dto.setHardwareList(hardwareTransactionJpaRepository.findAllByPerson_Id(person.getId()));
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
        dto.setPosition(positionJpaRepository.findPersonDetailsByPersonId(String.valueOf(person.getId())));
        dto.setRemainingBudget(budgetJpaRepository.findRemainingAmount(person.getId()));
        dto.setInitialBudget(budgetPositionJpaRepository.findByPosition_Id(person.getId()));
        dto.setHardwareList(hardwareTransactionJpaRepository.findAllByPerson_Id(person.getId()));
        return dto;
    }




    @Override
    public PersonDetailsDto findHardwareById(Long id) {
        Hardware hardware = hardwareJpaRepository.findHardwareById(id);
        PersonDetailsDto dto = new PersonDetailsDto();
        return dto;
    }

}
