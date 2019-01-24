package com.biss.demo.Budget2.dto;

import com.biss.demo.Budget2.model.HardwareTransaction;
import com.biss.demo.Budget2.model.HardwareType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HardwareDetailsDto {

    private Long id;
    private HardwareType hardwareType;
    private BigDecimal price;
    private Long serialNumber;
    @JsonIgnore
    private List<HardwareTransaction> hardwareTransactionList;
}
