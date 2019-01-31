package com.biss.demo.Budget2.repository;

import com.biss.demo.Budget2.model.Hardware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HardwareJpaRepository extends JpaRepository<Hardware, Long> {
    Hardware findHardwareById(final Long id);

    List<Hardware> findAllByHardwareType_Type (final String type);

    List<Hardware> findAllByHardwareType_Id (final Long id);

    Long getAllByHardwareTransactionList (final Long id);
}