package com.demo.Budget2.dto;

import lombok.*;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class HardwareTransactionTypeDto {

    private Long id;
    private String type;
}
