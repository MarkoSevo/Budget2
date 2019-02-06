package com.biss.demo.Budget2.service;

import com.biss.demo.Budget2.dto.GetHardwareTransaction;
import com.biss.demo.Budget2.dto.HardwareTransactionDto;

public interface HardwareTransactionDtoService {

    HardwareTransactionDto save(HardwareTransactionDto hardwareTransactionDto);
}