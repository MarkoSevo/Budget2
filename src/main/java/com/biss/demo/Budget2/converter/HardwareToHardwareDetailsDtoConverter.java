package com.biss.demo.Budget2.converter;

import com.biss.demo.Budget2.dto.HardwareDetailsDto;
import com.biss.demo.Budget2.model.Hardware;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HardwareToHardwareDetailsDtoConverter implements Converter<Hardware, HardwareDetailsDto> {

    @Override
    public HardwareDetailsDto convert(Hardware source) {
        return new HardwareDetailsDto(source.getId(),source.getHardwareType(),source.getPrice(),source.getSerialNumber(),null);
    }
}
