package com.demo.Budget2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HardwareDetailsDto {

    private Long id;
    private BigDecimal price;
    private Long serialNumber;
    private String hardwareType;
    private HardwareDetailsDto status;
    private LocalDateTime purchaseDate;
}
