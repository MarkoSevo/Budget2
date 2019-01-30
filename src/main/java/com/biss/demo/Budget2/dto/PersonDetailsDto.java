package com.biss.demo.Budget2.dto;
import com.biss.demo.Budget2.model.Position;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

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
}
