package com.biss.demo.Budget2.dto;

import com.biss.demo.Budget2.model.Position;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDetailsDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private Long positionId;
    private BigDecimal initialBudget;
    private BigDecimal remainingBudget;
    private Long hardwareId;
}
