package br.com.tokenlab.treinamentotesteunitario.service;

import br.com.tokenlab.treinamentotesteunitario.dto.EmployeeDTO;
import br.com.tokenlab.treinamentotesteunitario.repository.EmployeeRepositoy;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final ModelMapper modelMapper;
    private final EmployeeRepositoy employeeRepositoy;

    public EmployeeServiceImpl(ModelMapper modelMapper, EmployeeRepositoy employeeRepositoy) {
        this.modelMapper = modelMapper;
        this.employeeRepositoy = employeeRepositoy;
    }

    @Override
    public List<EmployeeDTO> findAllEmployees() {
        return employeeRepositoy.findAll().stream()
                .map(employee -> modelMapper.map(employee, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO findEmployeeById(Integer id) {
        return null;
    }
}
