package br.com.tokenlab.treinamentotesteunitario.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDTO {
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String email;

    @Builder
    public EmployeeDTO(Integer employeeId, String firstName, String lastName, String email) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
