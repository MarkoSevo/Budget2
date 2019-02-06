package com.biss.demo.Budget2.dto;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDetailsDto implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private Long positionId;
    private BigDecimal initialTransaction;
}
