package com.biss.demo.Budget2.converter;

import com.biss.demo.Budget2.dto.BudgetTransactionPersonDto;
import com.biss.demo.Budget2.model.BudgetTransaction;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BudgetTransactionPersonDtoBudgetTransaction implements Converter<BudgetTransactionPersonDto, BudgetTransaction> {
    @Override
    public BudgetTransaction convert(BudgetTransactionPersonDto source) {
        return new BudgetTransaction(null,null,source.getInputAmount(),source.getOutputAmount(),source.getTransactionDate(),null,null);
    }
}
