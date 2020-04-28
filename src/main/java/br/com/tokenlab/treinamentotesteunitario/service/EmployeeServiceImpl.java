package br.com.tokenlab.treinamentotesteunitario.service;

import br.com.tokenlab.treinamentotesteunitario.dto.EmployeeDTO;
import br.com.tokenlab.treinamentotesteunitario.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDTO> findAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(employee -> EmployeeDTO.builder()
                        .firstName(employee.getFirstName())
                        .lastName(employee.getLastName())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO findEmployeeById(Integer id) {
        return null;
    }
}
