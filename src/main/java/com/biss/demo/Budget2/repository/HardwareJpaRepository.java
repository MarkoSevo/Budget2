package com.biss.demo.Budget2.repository;

import com.biss.demo.Budget2.model.Hardware;
import com.biss.demo.Budget2.model.HardwareType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HardwareJpaRepository extends JpaRepository<Hardware, Long> {
    Hardware findHardwareById(final Long id);

    List<Hardware> findAllByHardwareType_Id (final Long typeId);

    List<Hardware> findAllByHardwareType_Type (final String type);

    Hardware findHardwareByHardwareType_Type (final String type);
}