package com.biss.demo.Budget2.converter;

import com.biss.demo.Budget2.dto.HardwareDto;
import com.biss.demo.Budget2.model.Hardware;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HardwareToHardwareDtoConverter implements Converter<Hardware, HardwareDto> {

    @Override
    public HardwareDto convert(Hardware source) {
        return new HardwareDto(source.getId(),source.getVersion(),source.getSerialNumber(),source.getPrice(),source.getPurchaseDate(),source.getHardwareType(),null);
    }
}
