package com.biss.demo.Budget2.repository;

import com.biss.demo.Budget2.model.Person;
import com.biss.demo.Budget2.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PersonJpaRepository extends JpaRepository<Person, Long> {

    Person findPersonByUserName(String userName);
}