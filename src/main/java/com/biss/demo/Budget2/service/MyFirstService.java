package com.biss.demo.Budget2.service;

import com.biss.demo.Budget2.dto.PersonDetailsDto;
import org.springframework.data.jpa.repository.Query;

public interface MyFirstService {

     PersonDetailsDto findPersonByUserName(String userName);

     PersonDetailsDto findBudgetById(Long id);

     PersonDetailsDto findHardwareById(Long id);

    @Query(value = "SELECT FIRST_NAME, LAST_NAME,POSITION_ID\n" +
            "FROM PERSON\n" +
            "JOIN PERSON_POSITION PP on PERSON.ID = PP.PERSON_ID\n" +
            "where PERSON.ID = ?", nativeQuery = true)
    PersonDetailsDto findPersonDetailsByPersonId(Long id);

    @Query(value = "SELECT SUM(INPUT_AMOUNT)-SUM(OUTPUT_AMOUNT) FROM BUDGET_TRANSACTION WHERE PERSON_ID = ?", nativeQuery = true)
    Long findRemainingAmount (Long id);
//
//    @Query (value = "SELECT FIRST_NAME, LAST_NAME, POSITION, AMOUNT\n" +
//            "FROM PERSON\n" +
//            "\tJOIN POSITION\n" +
//            "ON PERSON.POSITION_ID = POSITION.ID\n" +
//            "\tJOIN BUDGET\n" +
//            "ON BUDGET.ID = POSITION.ID" +
//            "WHERE PERSON.ID = ?", nativeQuery = true)
//    String findInitialAmount (Long id);

//    @Query(value = "SELECT HARDWARE_TRANSACTION.HARDWARE_ID, HARDWARE_TRANSACTION_TYPE.TYPE\n" +
//            "FROM HARDWARE_TRANSACTION\n" +
//            "\tJOIN PERSON\n" +
//            "ON HARDWARE_TRANSACTION.PERSON_ID\t= PERSON.ID\n" +
//            "\tJOIN HARDWARE_TRANSACTION_TYPE\n" +
//            "ON HARDWARE_TRANSACTION.HARDWARE_TRANSACTION_TYPE_ID= HARDWARE_TRANSACTION_TYPE.ID\n" +
//            "WHERE PERSON.ID = ?", nativeQuery = true)
//    List<HardwareTransaction> findHardwareTransactions(Long id);
}
