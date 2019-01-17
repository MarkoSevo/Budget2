package com.biss.demo.Budget2.service.impl;

import com.biss.demo.Budget2.dto.PersonDetailsDto;
import com.biss.demo.Budget2.model.Budget;
import com.biss.demo.Budget2.model.Hardware;
import com.biss.demo.Budget2.model.HardwareTransaction;
import com.biss.demo.Budget2.model.Person;
import com.biss.demo.Budget2.repository.*;
import com.biss.demo.Budget2.service.MyFirstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MyFirstServiceImpl implements MyFirstService {
    
    private final BudgetJpaRepository budgetJpaRepository;
    private final PersonJpaRepository personJpaRepository;
    private final HardwareJpaRepository hardwareJpaRepository;
    private final PositionJpaRepository positionJpaRepository;

    @Autowired
    public MyFirstServiceImpl(BudgetJpaRepository budgetJpaRepository, PersonJpaRepository personJpaRepository, HardwareJpaRepository hardwareJpaRepository, PositionJpaRepository positionJpaRepository) {
        this.budgetJpaRepository = budgetJpaRepository;
        this.personJpaRepository = personJpaRepository;
        this.hardwareJpaRepository = hardwareJpaRepository;
        this.positionJpaRepository = positionJpaRepository;

    }

    @Override
    public PersonDetailsDto findPersonByUserName(String username) {
        Person person = personJpaRepository.findPersonByUserName(username);
        PersonDetailsDto dto = new PersonDetailsDto();
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setEmail(person.getEmail());
        dto.setUserName(person.getUserName());
        dto.setPositionId(personJpaRepository.findPersonDetailsByPersonId(person.getId()));
        dto.setRemainingBudget(personJpaRepository.findRemainingAmount(person.getId()));
//        dto.setInitialBudget(personJpaRepository.findInitialBudget(person.getId()));
//        dto.setHardwareTransactionList(personJpaRepository.findHardwareTransactions(person.getId()));
        return dto;

//        dto.setHardwareId(hardwareJpaRepository.findHardwareById(person.getId()));
//        dto.setInitialBudget(budgetJpaRepository.findBudgetById(person.getId()));
//        dto.setRemainingBudget(budgetJpaRepository.findBudgetById(person.getId()));
//        dto.setPosition(personJpaRepository.findPersonDetailsByPersonId(person.getId()));
//        dto.setPosition(positionJpaRepository.findPositionsById(person.getId()));
    }

    @Override
    public PersonDetailsDto findBudgetById(Long id) {
        Budget budget = budgetJpaRepository.findBudgetById(id);
        PersonDetailsDto dto = new PersonDetailsDto();
        return dto;
    }

    @Override
    public PersonDetailsDto findHardwareById(Long id) {
        Hardware hardware = hardwareJpaRepository.findHardwareById(id);
        PersonDetailsDto dto = new PersonDetailsDto();
        return dto;
    }

    @Override
    public PersonDetailsDto findPersonDetailsByPersonId(Long id) {
        return null;
    }

    @Override
    public Long findRemainingAmount(Long id) {
        return null;
    }

}

//    @Override
//    public PersonDetailsDto findPersonDetailsByPersonId(Long id)
//    {
//        Person person = personJpaRepository.getOne(id);
//        PersonDetailsDto personDetailsDto = new PersonDetailsDto();
//        personDetailsDto.setFirstName(person.getFirstName());
//        personDetailsDto.setLastName(person.getLastName());
//        personDetailsDto.setPosition(personJpaRepository.findPersonDetailsByPersonId(person.getId()));
//        return personDetailsDto;
//        return  null;
//    }
