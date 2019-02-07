package com.biss.demo.Budget2.converter;

import com.biss.demo.Budget2.dto.HardwareBudgetTransactionDto;
import com.biss.demo.Budget2.model.HardwareBudgetTransaction;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HardwareBudgetTransactionToHardwareBudgetTransactionDto implements Converter<HardwareBudgetTransaction, HardwareBudgetTransactionDto> {
    @Override
    public HardwareBudgetTransactionDto convert(HardwareBudgetTransaction source) {
        return new HardwareBudgetTransactionDto(source.getBudgetTransaction().getPerson().getId(),source.getHardware().getId(),source.getBudgetTransaction().getId());
    }
}
