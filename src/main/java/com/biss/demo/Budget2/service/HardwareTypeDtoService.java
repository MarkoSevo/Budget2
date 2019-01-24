package com.biss.demo.Budget2.service;

import com.biss.demo.Budget2.dto.HardwareTypeDto;
import com.biss.demo.Budget2.model.HardwareType;

public interface HardwareTypeDtoService {

    HardwareType findHardwareByHardwareType_Type (final String type);
}
