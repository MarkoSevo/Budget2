package com.biss.demo.Budget2.converter;

import com.biss.demo.Budget2.dto.HardwareTransactionDto;
import com.biss.demo.Budget2.model.HardwareTransaction;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HardwareTransactionToHardwareTransactionDto implements Converter<HardwareTransaction, HardwareTransactionDto> {
    @Override
    public HardwareTransactionDto convert(HardwareTransaction source) {
        return new HardwareTransactionDto(source.getId(),source.getVersion(),source.getTransactionDate(),null,source.getHardware(),source.getHardwareTransactionType());
    }
}
