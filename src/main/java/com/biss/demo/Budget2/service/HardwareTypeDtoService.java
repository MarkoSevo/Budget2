package com.biss.demo.Budget2.service;

import com.biss.demo.Budget2.dto.HardwareTypeDto;
import java.util.List;

public interface HardwareTypeDtoService {

    HardwareTypeDto getOneById (Long id);

    List<HardwareTypeDto> findAll();

    HardwareTypeDto save(HardwareTypeDto hardwareTypeDto);
}
