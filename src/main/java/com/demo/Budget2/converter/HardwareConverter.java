package com.demo.Budget2.converter;

import com.demo.Budget2.dto.HardwareDetailsDto;
import com.demo.Budget2.model.Hardware;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

public class HardwareConverter {

    @Component
    public static class HardwareDetailsDtoToHardware implements Converter<HardwareDetailsDto, Hardware> {

        @Override
        public Hardware convert(HardwareDetailsDto source) {
            return new Hardware(source.getId(),null,source.getSerialNumber(),source.getPrice(),
                    null,null,null,null);
        }
    }

    @Component
    public static class HardwareToHardwareDetailsDto implements Converter<Hardware, HardwareDetailsDto> {

        @Override
        public HardwareDetailsDto convert(Hardware source) {
            return new HardwareDetailsDto(source.getId(),source.getPrice(),source.getSerialNumber(),source.getHardwareType().getType(),null, source.getPurchaseDate());
        }
    }
}
