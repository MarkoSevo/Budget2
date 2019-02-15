package com.biss.demo.Budget2.repository;

import com.biss.demo.Budget2.model.HardwareType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HardwareTypeJpaRepository extends JpaRepository<HardwareType, Long> {

    List<HardwareType> findHardwareTypeIdByType (String type);
}