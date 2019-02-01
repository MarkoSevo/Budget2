package com.biss.demo.Budget2.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDetailsDto {

    private Long idDto;
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private Long positionId;
}
