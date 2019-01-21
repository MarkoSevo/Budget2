package com.biss.demo.Budget2.service.impl;

import com.biss.demo.Budget2.dto.PersonDetailsDto;
import com.biss.demo.Budget2.model.*;
import com.biss.demo.Budget2.repository.*;
import com.biss.demo.Budget2.service.PersonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class PersonDetailsServiceImpl implements PersonDetailsService {

    private final BudgetJpaRepository budgetJpaRepository;
    private final PersonJpaRepository personJpaRepository;
    private final HardwareJpaRepository hardwareJpaRepository;
    private final PositionJpaRepository positionJpaRepository;
    private final HardwareTransactionJpaRepository hardwareTransactionJpaRepository;

    @Autowired
    public PersonDetailsServiceImpl(BudgetJpaRepository budgetJpaRepository, PersonJpaRepository personJpaRepository, HardwareJpaRepository hardwareJpaRepository, PositionJpaRepository positionJpaRepository, HardwareTransactionJpaRepository hardwareTransactionJpaRepository) {
        this.budgetJpaRepository = budgetJpaRepository;
        this.personJpaRepository = personJpaRepository;
        this.hardwareJpaRepository = hardwareJpaRepository;
        this.positionJpaRepository = positionJpaRepository;
        this.hardwareTransactionJpaRepository = hardwareTransactionJpaRepository;
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
        dto.setInitialBudget(budgetJpaRepository.findInitialBudget(String.valueOf(person.getId())));
        dto.setHardwareTransactionList(hardwareTransactionJpaRepository.findHardwareTransactionsByPersonId(person.getId()));
//        dto.setHardwareList(hardwareJpaRepository.findHardwaresByPersonId(person.getId()));
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
        dto.setInitialBudget(budgetJpaRepository.findInitialBudget(String.valueOf(person.getId())));
        dto.setHardwareTransactionList(hardwareTransactionJpaRepository.findHardwareTransactionsByPersonId(person.getId()));
        //  dto.setHardwareList(hardwareJpaRepository.findHardwaresByPersonId(person.getId()));
        return dto;
    }


    @Override
    public PersonDetailsDto findHardwareById(Long id) {
        Hardware hardware = hardwareJpaRepository.findHardwareById(id);
        PersonDetailsDto dto = new PersonDetailsDto();
        return dto;
    }

}
