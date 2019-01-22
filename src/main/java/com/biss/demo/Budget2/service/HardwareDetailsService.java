package com.biss.demo.Budget2.service;

import com.biss.demo.Budget2.dto.HardwareDetailsDto;

public interface HardwareDetailsService {

    HardwareDetailsDto findByHardwareType (String hardwareType);

}
