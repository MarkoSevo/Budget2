package com.biss.demo.Budget2.service;

import com.biss.demo.Budget2.dto.HardwareDetailsDto;
import com.biss.demo.Budget2.model.Hardware;
import com.biss.demo.Budget2.model.HardwareType;

import java.util.List;

public interface HardwareDetailsService {

    List<HardwareDetailsDto> findByHardwareType_Type (String hardwareType);

    HardwareDetailsDto save(HardwareDetailsDto hardwareDetailsDto);

    List<HardwareDetailsDto> findAll();

    List<HardwareDetailsDto> findAllByHardwareType_Id (Long id);

}
