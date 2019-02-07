package com.biss.demo.Budget2.service;

import com.biss.demo.Budget2.dto.HardwareBudgetTransactionDto;

import java.util.List;

public interface HardwareBudgetTransactionDtoService  {

    List<HardwareBudgetTransactionDto> findAllByPersonId (Long id);
}
