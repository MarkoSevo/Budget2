package com.biss.demo.Budget2.service;

import com.biss.demo.Budget2.dto.PersonDetailsDto;
import com.biss.demo.Budget2.model.HardwareTransaction;
import com.biss.demo.Budget2.model.Person;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonDetailsService {

    PersonDetailsDto findPersonByUserName(String userName);

     PersonDetailsDto findBudgetById(Long id);

     PersonDetailsDto findHardwareById(Long id);

     List<HardwareTransaction> findHardwareTransactions(Long id);

    @Query(value = "SELECT FIRST_NAME, LAST_NAME,POSITION_ID\n" +
            "FROM PERSON\n" +
            "JOIN PERSON_POSITION PP on PERSON.ID = PP.PERSON_ID\n" +
            "where PERSON.ID = ?", nativeQuery = true)
    PersonDetailsDto findPersonDetailsByPersonId(Long id);

    @Query(value = "SELECT SUM(INPUT_AMOUNT)-SUM(OUTPUT_AMOUNT) FROM BUDGET_TRANSACTION WHERE PERSON_ID = ?", nativeQuery = true)
    Long findRemainingAmount (Long id);

    void save(PersonDetailsDto newPerson);
}
