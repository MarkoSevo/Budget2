package com.demo.Budget2.dto;

import lombok.*;
import java.io.Serializable;
import java.time.LocalDateTime;

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
