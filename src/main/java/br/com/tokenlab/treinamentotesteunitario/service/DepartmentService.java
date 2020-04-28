package br.com.tokenlab.treinamentotesteunitario.service;

import br.com.tokenlab.treinamentotesteunitario.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {

    List<DepartmentDTO> findAllDepartments();

    DepartmentDTO findDepartmentById(Integer departmentId, boolean includeEmployees, boolean includeLocation);
}