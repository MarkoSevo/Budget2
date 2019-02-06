package com.biss.demo.Budget2.service;

import com.biss.demo.Budget2.dto.BudgetTransactionPersonDto;

import java.util.List;

public interface BudgetTransactionPersonDtoService {

    List<BudgetTransactionPersonDto> findAllByPersonId (Long id);
}
