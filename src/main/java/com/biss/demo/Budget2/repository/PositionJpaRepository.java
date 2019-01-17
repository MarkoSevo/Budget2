package com.biss.demo.Budget2.repository;

import com.biss.demo.Budget2.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PositionJpaRepository extends JpaRepository<Position, Long> {
    Position findPositionsById (Long Id);
    Position findPositionByPosition (Long Position);
}
