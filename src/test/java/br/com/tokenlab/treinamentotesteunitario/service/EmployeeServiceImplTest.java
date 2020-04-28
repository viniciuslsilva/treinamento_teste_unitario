package br.com.tokenlab.treinamentotesteunitario.service;

import br.com.tokenlab.treinamentotesteunitario.domain.Employee;
import br.com.tokenlab.treinamentotesteunitario.dto.EmployeeDTO;
import br.com.tokenlab.treinamentotesteunitario.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeServiceImpl employeeService;

    @Test
    void testFindAllEmployees() {
        final String employeeFirstName = "Rogerio";
        final String employeeLastName = "Silva";

        List<Employee> list = new ArrayList<>();
        list.add(Employee.builder()
                .firstName(employeeFirstName)
                .lastName(employeeLastName)
                .build());

        given(employeeRepository.findAll()).willReturn(list);

        List<EmployeeDTO> employeeDTOList = employeeService.findAllEmployees();

        then(employeeRepository).should(times(1)).findAll();
        assertEquals(1, employeeDTOList.size());

        EmployeeDTO employeeDTO = employeeDTOList.get(0);
        assertTrue(employeeFirstName.equalsIgnoreCase(employeeDTO.getFirstName()));
        assertTrue(employeeLastName.equalsIgnoreCase(employeeDTO.getLastName()));

        assertThat(1).isEqualTo(employeeDTOList.size());
        assertThat(employeeFirstName).isEqualToIgnoringCase(employeeDTO.getFirstName());
        assertThat(employeeLastName).isEqualToIgnoringCase(employeeDTO.getLastName());
    }

    @Test
    void testFindEmployeeById() {
    }
}