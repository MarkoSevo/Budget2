package com.demo.Budget2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetPersonDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String position;
    private BigDecimal initialBudget;
    private BigDecimal remainingBudget;
}
