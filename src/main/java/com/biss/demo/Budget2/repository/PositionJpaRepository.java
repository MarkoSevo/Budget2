package com.biss.demo.Budget2.repository;

import com.biss.demo.Budget2.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionJpaRepository extends JpaRepository<Position, Long> {

    @Query(value = "SELECT POSITION_ID\n" +
            "FROM PERSON_POSITION \n" +
            "LEFT JOIN POSITION P on PERSON_POSITION.POSITION_ID = P.ID\n" +
            "WHERE PERSON_ID = ?", nativeQuery = true)
    Long findPersonDetailsByPersonId(String position);

    Position findPositionByPosition (String position);


}


