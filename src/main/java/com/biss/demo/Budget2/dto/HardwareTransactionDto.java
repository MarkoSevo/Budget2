package com.biss.demo.Budget2.dto;

import com.biss.demo.Budget2.model.Hardware;
import com.biss.demo.Budget2.model.HardwareTransactionType;
import com.biss.demo.Budget2.model.Person;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class HardwareTransactionDto {
    @JsonIgnore
    private Long id;
    @JsonIgnore
    private Long version;
    private Date transactionDate;
    private HardwareDetailsDto hardwareDetailsDto;
    private PersonDetailsDto personDetailsDto;
    private HardwareTransactionTypeDto HardwareTransactionTypeDto;
}
