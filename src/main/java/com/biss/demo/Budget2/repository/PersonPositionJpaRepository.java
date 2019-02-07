package com.biss.demo.Budget2.repository;

import com.biss.demo.Budget2.model.PersonPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface PersonPositionJpaRepository extends JpaRepository<PersonPosition, Long> {

    @Query(value = "SELECT POSITION\n" +
            "FROM PERSON_POSITION \n" +
            "LEFT JOIN POSITION P on PERSON_POSITION.POSITION_ID = P.ID\n" +
            "WHERE PERSON_ID = ?", nativeQuery = true)
    String findPersonDetailsByPersonId(String position);

    @Query(value = "SELECT POSITION, AMOUNT, PERSON_ID\n" +
            "FROM PERSON_POSITION\n" +
            "JOIN POSITION\n" +
            "ON PERSON_POSITION.POSITION_ID = POSITION.ID\n" +
            "JOIN BUDGET\n" +
            "ON BUDGET.ID = POSITION.ID\n" +
            "WHERE PERSON_ID = ?", nativeQuery = true)
    BigDecimal findInitialBudget (String position);


}
