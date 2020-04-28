package br.com.tokenlab.treinamentotesteunitario.service;

import br.com.tokenlab.treinamentotesteunitario.dto.EmployeeDTO;
import br.com.tokenlab.treinamentotesteunitario.repository.EmployeeRepositoy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepositoy employeeRepositoy;

    public EmployeeServiceImpl(EmployeeRepositoy employeeRepositoy) {
        this.employeeRepositoy = employeeRepositoy;
    }

    @Override
    public List<EmployeeDTO> findAllEmployees() {
        return employeeRepositoy.findAll().stream()
                .map(employee -> EmployeeDTO.builder()
                        .firstName(employee.getFirstName())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO findEmployeeById(Integer id) {
        return null;
    }
}
