package com.biss.demo.Budget2.repository;

import com.biss.demo.Budget2.dto.PersonDetailsDto;
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
}