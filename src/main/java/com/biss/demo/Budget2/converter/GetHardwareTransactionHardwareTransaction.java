package com.biss.demo.Budget2.converter;

import com.biss.demo.Budget2.dto.GetHardwareTransaction;
import com.biss.demo.Budget2.model.HardwareTransaction;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GetHardwareTransactionHardwareTransaction implements Converter<GetHardwareTransaction, HardwareTransaction> {
    @Override
    public HardwareTransaction convert(GetHardwareTransaction source) {
        return new HardwareTransaction(null,null,source.getTransactionDate(),null, null,null);
    }
}
