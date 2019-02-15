package com.biss.demo.Budget2.dto;

import lombok.*;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDetailsDto{

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private Long positionId;
}
