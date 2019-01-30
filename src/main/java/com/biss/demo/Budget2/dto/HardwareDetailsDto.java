package com.biss.demo.Budget2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HardwareDetailsDto {

    private Long id;
    private BigDecimal price;
    private Long serialNumber;
    private HardwareTypeDto hardwareTypeDto;

}
