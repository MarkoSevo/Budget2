package com.biss.demo.Budget2.dto;


import com.biss.demo.Budget2.model.BudgetPosition;
import com.biss.demo.Budget2.model.Position;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BudgetDto {

    private Long id;

    @JsonIgnore
    private Long version;

    private BigDecimal amount;

    @JsonIgnore
    private List<Position> positionList;
}
