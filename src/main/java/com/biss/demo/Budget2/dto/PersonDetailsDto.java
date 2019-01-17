package com.biss.demo.Budget2.dto;

import com.biss.demo.Budget2.model.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDetailsDto {

    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private Long initialBudget;
    private Long remainingBudget;
    private String position;
    private List<Hardware> hardwareList;

    @JsonIgnore
    private List<BudgetTransaction> budgetTransactionList;

    private List<HardwareTransaction> hardwareTransactionList;

    @JsonIgnore
    private List<PersonPosition> personPositionList;
}
