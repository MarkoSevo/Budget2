package com.demo.Budget2.service;

import com.demo.Budget2.dto.HardwareTypeDto;

import java.util.List;

public interface HardwareTypeDtoService {

    HardwareTypeDto getOneById (Long id);

    List<HardwareTypeDto> findAll();

    HardwareTypeDto save(HardwareTypeDto hardwareTypeDto);
}
