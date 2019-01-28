package com.biss.demo.Budget2.dto;

import com.biss.demo.Budget2.model.*;
import com.biss.demo.Budget2.repository.PositionJpaRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDetailsDto {


    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private Set<Position> positionList;
    private BigDecimal initialBudget;
    private BigDecimal remainingBudget;
    private List<Hardware> hardwareList;

    @JsonIgnore
    private List<BudgetTransaction> budgetTransactionList;

    @JsonIgnore
    private List<HardwareTransaction> hardwareTransactionList;
}
