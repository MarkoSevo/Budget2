package com.biss.demo.Budget2.converter;

import com.biss.demo.Budget2.dto.HardwareTransactionTypeDto;
import com.biss.demo.Budget2.model.HardwareTransaction;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HardwareTransactionToHardwareTransactionTypeDto implements Converter<HardwareTransaction, HardwareTransactionTypeDto> {
    @Override
    public HardwareTransactionTypeDto convert(HardwareTransaction source) {
        return new HardwareTransactionTypeDto(source.getId(),source.toString());
    }
}
