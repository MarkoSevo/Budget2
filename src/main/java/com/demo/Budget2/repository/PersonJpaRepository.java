package com.demo.Budget2.repository;

import com.demo.Budget2.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonJpaRepository extends JpaRepository<Person, Long> {

    Person findPersonByUserName(String userName);
}