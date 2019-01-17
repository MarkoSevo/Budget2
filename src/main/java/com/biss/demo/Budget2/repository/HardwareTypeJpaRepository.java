package com.biss.demo.Budget2.repository;

import com.biss.demo.Budget2.model.HardwareType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HardwareTypeJpaRepository extends JpaRepository<HardwareType, Long> {
    HardwareType findHardwareTypeById(final Long id);
    List<HardwareType> findAllByType (final String type);
}