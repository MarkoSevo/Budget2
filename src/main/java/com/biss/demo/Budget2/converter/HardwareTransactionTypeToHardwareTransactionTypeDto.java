package com.biss.demo.Budget2.converter;

import com.biss.demo.Budget2.dto.HardwareTransactionTypeDto;
import com.biss.demo.Budget2.model.HardwareTransaction;
import com.biss.demo.Budget2.model.HardwareTransactionType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HardwareTransactionTypeToHardwareTransactionTypeDto implements Converter<HardwareTransactionType, HardwareTransactionTypeDto> {
    @Override
    public HardwareTransactionTypeDto convert(HardwareTransactionType source) {
        return new HardwareTransactionTypeDto(source.getId(),source.getType());
    }
}
