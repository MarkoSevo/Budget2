package com.biss.demo.Budget2.converter;

import com.biss.demo.Budget2.dto.HardwareTransactionTypeDto;
import com.biss.demo.Budget2.model.HardwareTransactionType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HardwareTransactionTypeDtoToHardwareTransaction implements Converter <HardwareTransactionTypeDto, HardwareTransactionType> {
    @Override
    public HardwareTransactionType convert(HardwareTransactionTypeDto source) {
        return new HardwareTransactionType(source.getId(),null,source.getType(),null);
    }
}
