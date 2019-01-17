package com.biss.demo.Budget2.repository;

import com.biss.demo.Budget2.model.HardwareTransaction;
import com.biss.demo.Budget2.model.Person;
import com.biss.demo.Budget2.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonJpaRepository extends JpaRepository<Person, Long> {
    List<Person> findPersonByFirstName(String firstName);

    List<Person> findPersonByLastName(String lastName);

    List<Person> findPersonByFirstNameAndLastName(String firstName, String lastName);

    List<Person> findPersonByEmail(String email);

    Person findPersonByUserName(String userName);

    List<Person> findByPositionList(String position);

    Position findByPositionList(Position positionsById);

    @Query(value = "SELECT POSITION_ID \n" +
            "FROM PERSON\n" +
            "JOIN PERSON_POSITION PP on PERSON.ID = PP.PERSON_ID\n" +
            "where PERSON.ID = ?", nativeQuery = true)
    String findPersonDetailsByPersonId(Long id);

    @Query(value = "SELECT SUM(INPUT_AMOUNT)-SUM(OUTPUT_AMOUNT) FROM BUDGET_TRANSACTION WHERE PERSON_ID = ?", nativeQuery = true)
    Long findRemainingAmount (Long id);
//
//    @Query(value = "SELECT AMOUNT FROM BUDGET\n" +
//            "JOIN POSITION\n" +
//            "WHERE POSITION.ID = ?", nativeQuery = true)
//    Long findInitialBudget (Long id);


}