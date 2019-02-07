package com.biss.demo.Budget2.converter;

import com.biss.demo.Budget2.dto.HardwareBudgetTransactionDto;
import com.biss.demo.Budget2.model.HardwareBudgetTransaction;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HardwareBudgetTransactionDtoToHardwareBudgetTransaction implements Converter<HardwareBudgetTransactionDto, HardwareBudgetTransaction> {
    @Override
    public HardwareBudgetTransaction convert(HardwareBudgetTransactionDto source) {
        return new HardwareBudgetTransaction(null,null);
    }
}
