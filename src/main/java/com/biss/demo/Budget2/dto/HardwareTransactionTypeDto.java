package com.biss.demo.Budget2.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class HardwareTransactionTypeDto {
    @JsonIgnore
    private Long id;
    private String type;
}
