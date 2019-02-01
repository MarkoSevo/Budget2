package com.biss.demo.Budget2.converter;

import com.biss.demo.Budget2.dto.BudgetInputTransactionDto;
import com.biss.demo.Budget2.model.BudgetTransaction;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BudgetInputTransactionDtoToBudgetInputTransaction implements Converter<BudgetInputTransactionDto, BudgetTransaction> {
    @Override
    public BudgetTransaction convert(BudgetInputTransactionDto source) {
        return new BudgetTransaction(null,null,source.getAmount(),null,source.getTransactionDate(),null,null);
    }
}
