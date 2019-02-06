package com.biss.demo.Budget2.dto;

import lombok.*;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class HardwareTransactionTypeDto implements Serializable {

    private Long id;
    private String type;
}
