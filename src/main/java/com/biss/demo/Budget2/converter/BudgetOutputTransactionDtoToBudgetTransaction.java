package com.biss.demo.Budget2.converter;

import com.biss.demo.Budget2.dto.BudgetOutputTransactionDto;
import com.biss.demo.Budget2.model.BudgetTransaction;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BudgetOutputTransactionDtoToBudgetTransaction implements Converter<BudgetOutputTransactionDto, BudgetTransaction> {
    @Override
    public BudgetTransaction convert(BudgetOutputTransactionDto source) {
        return new BudgetTransaction(null,null,null,source.getAmount(),source.getTransactionDate(),null,null);
    }
}
