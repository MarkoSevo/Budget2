package com.biss.demo.Budget2.converter;

import com.biss.demo.Budget2.dto.GetHardwareTransaction;
import com.biss.demo.Budget2.model.HardwareTransaction;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HardwareTransactionGetHardwareTransaction implements Converter<HardwareTransaction, GetHardwareTransaction> {
    @Override
    public GetHardwareTransaction convert(HardwareTransaction source) {
        return new GetHardwareTransaction(source.getPerson().getId(), source.getTransactionDate(),source.getHardware().getId(),source.getHardwareTransactionType().getType());
    }
}
