package com.biss.demo.Budget2.repository;

import com.biss.demo.Budget2.dto.PositionDto;
import com.biss.demo.Budget2.model.PersonPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonPositionJpaRepository extends JpaRepository<PersonPosition, Long> {

    PositionDto findByPerson_Id (Long id);

}
