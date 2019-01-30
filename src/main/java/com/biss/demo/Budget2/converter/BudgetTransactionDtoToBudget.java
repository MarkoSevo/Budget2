package com.biss.demo.Budget2.converter;

import com.biss.demo.Budget2.dto.BudgetTransactionDto;
import com.biss.demo.Budget2.model.BudgetTransaction;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BudgetTransactionDtoToBudget implements Converter< BudgetTransactionDto , BudgetTransaction> {
    @Override
    public BudgetTransaction convert(BudgetTransactionDto source) {
        return new BudgetTransaction(null,null,source.getInputAmount(),source.getOutputAmount(),source.getTransactionDate(),null,null);
    }
}
