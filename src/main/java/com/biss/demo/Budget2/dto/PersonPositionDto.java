package com.biss.demo.Budget2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonPositionDto {

    private Date validFrom;
    private Date validTo;
    private PositionDto positionDto;
    private PersonDetailsDto personDetailsDto;
}
