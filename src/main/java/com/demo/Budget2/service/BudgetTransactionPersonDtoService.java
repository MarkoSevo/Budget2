package com.demo.Budget2.service;

import com.demo.Budget2.dto.BudgetTransactionPersonDto;

import java.util.List;

public interface BudgetTransactionPersonDtoService {

    List<BudgetTransactionPersonDto> findAllByPersonId (Long id);
}
