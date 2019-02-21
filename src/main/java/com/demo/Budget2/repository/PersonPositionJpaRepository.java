package com.demo.Budget2.repository;

import com.demo.Budget2.model.PersonPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonPositionJpaRepository extends JpaRepository<PersonPosition, Long> {

    @Query(value = "SELECT POSITION\n" +
            "FROM PERSON_POSITION \n" +
            "LEFT JOIN POSITION P on PERSON_POSITION.POSITION_ID = P.ID\n" +
            "WHERE PERSON_ID = ?", nativeQuery = true)
    String findPersonDetailsByPersonId(String position);

}
