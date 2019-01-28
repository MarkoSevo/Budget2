package com.biss.demo.Budget2.converter;

import com.biss.demo.Budget2.dto.HardwareTransactionDto;
import com.biss.demo.Budget2.model.HardwareTransaction;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HardwareTransactionDtoToHardwareTransaction implements Converter<HardwareTransactionDto, HardwareTransaction> {
    @Override
    public HardwareTransaction convert(HardwareTransactionDto source) {
        return new HardwareTransaction(source.getId(),source.getVersion(),source.getTransactionDate(),source.getPerson(),source.getHardwareTransactionType(),source.getHardware());
    }
}
