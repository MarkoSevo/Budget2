package com.biss.demo.Budget2.service;

import com.biss.demo.Budget2.dto.HardwareTransactionDto;

import java.util.List;

public interface HardwareTransactionDtoService {

    HardwareTransactionDto save(HardwareTransactionDto hardwareTransactionDto);

    HardwareTransactionDto getPersonHardware(Long id);

    List<HardwareTransactionDto> getAllByPersonId ();


}
