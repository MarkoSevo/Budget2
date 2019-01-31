package com.biss.demo.Budget2.service;

import com.biss.demo.Budget2.dto.HardwareDetailsDto;
import java.util.List;

public interface HardwareDetailsService {

    List<HardwareDetailsDto> findByHardwareType_Type (String hardwareType);

    HardwareDetailsDto save(HardwareDetailsDto hardwareDetailsDto);

    List<HardwareDetailsDto> findAll();

    List<HardwareDetailsDto> findAllByHardwareType_Id (Long id);
}
