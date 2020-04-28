package br.com.tokenlab.treinamentotesteunitario.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DepartmentDTO {
    private Integer departmentId;
    private String departmentName;
    private List<EmployeeDTO> employees;
    private LocationDTO location;

    @Builder
    public DepartmentDTO(Integer departmentId, String departmentName, List<EmployeeDTO> employees, LocationDTO location) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.employees = employees;
        this.location = location;
    }
}
