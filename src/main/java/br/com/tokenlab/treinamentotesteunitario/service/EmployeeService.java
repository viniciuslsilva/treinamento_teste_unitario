package br.com.tokenlab.treinamentotesteunitario.service;

import br.com.tokenlab.treinamentotesteunitario.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> findAllEmployees();

    EmployeeDTO findEmployeeById(Integer id);

}
