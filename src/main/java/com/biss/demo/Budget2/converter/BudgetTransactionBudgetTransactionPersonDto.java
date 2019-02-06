package com.biss.demo.Budget2.converter;

import com.biss.demo.Budget2.dto.BudgetTransactionPersonDto;
import com.biss.demo.Budget2.model.BudgetTransaction;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BudgetTransactionBudgetTransactionPersonDto implements Converter<BudgetTransaction, BudgetTransactionPersonDto> {
    @Override
    public BudgetTransactionPersonDto convert(BudgetTransaction source) {
        return new BudgetTransactionPersonDto(source.getPerson().getId(),source.getInputAmount(),source.getOutputAmount(),source.getTransactionDate());
    }
}
