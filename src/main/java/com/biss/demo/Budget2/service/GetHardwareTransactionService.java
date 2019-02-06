package com.biss.demo.Budget2.service;

import com.biss.demo.Budget2.dto.GetHardwareTransaction;

import java.util.List;

public interface GetHardwareTransactionService {

    List<GetHardwareTransaction> findAllByPerson(Long id);

    List<GetHardwareTransaction> findAllByHardware(Long id);
}
