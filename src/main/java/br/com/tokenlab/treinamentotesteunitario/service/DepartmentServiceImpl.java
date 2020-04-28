package br.com.tokenlab.treinamentotesteunitario.service;

import br.com.tokenlab.treinamentotesteunitario.domain.Department;
import br.com.tokenlab.treinamentotesteunitario.dto.DepartmentDTO;
import br.com.tokenlab.treinamentotesteunitario.dto.LocationDTO;
import br.com.tokenlab.treinamentotesteunitario.repository.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import static java.util.stream.Collectors.toList;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private ModelMapper modelMapper;
    private DepartmentRepository deptRepo;

    public DepartmentServiceImpl(ModelMapper modelMapper, DepartmentRepository deptRepo) {
        this.modelMapper = modelMapper;
        this.deptRepo = deptRepo;
    }

    @Override
    public List<DepartmentDTO> findAllDepartments() {
        return deptRepo.findAll().stream().map(
                dept -> DepartmentDTO.builder()
                        .departmentId(dept.getDepartmentId())
                        .build())
                .collect(toList());
    }

    @Override
    public DepartmentDTO findDepartmentById(Integer departmentId, boolean includeEmployees, boolean includeLocation) {
        if (includeEmployees && !includeLocation) {
            return deptRepo.findWithEmployeesNoLocationByDepartmentId(departmentId)
                    .map(dept -> modelMapper.map(dept, DepartmentDTO.class))
                    .orElseThrow(resourceNotFound(departmentId));
        } else if (includeLocation) {
            Optional<Department> deptEntity;
            if (includeEmployees) {
                //both location and employees
                deptEntity = deptRepo.findWithEmployeesAndLocationByDepartmentId(departmentId);
            } else {
                //only location.
                deptEntity = deptRepo.findWithLocationByDepartmentId(departmentId);
            }
            return deptEntity
                    .map(dept -> {
                        DepartmentDTO deptDto = modelMapper.map(dept, DepartmentDTO.class);
                        //explicitly add location.
                        deptDto.setLocation(modelMapper.map(dept.getLocation(), LocationDTO.class));
                        return deptDto;
                    })
                    .orElseThrow(resourceNotFound(departmentId));
        } else {
            //both flags are false, so no association fields (employees, location) to be fetched.
            return deptRepo.findById(departmentId)
                    .map(dept -> modelMapper.map(dept, DepartmentDTO.class))
                    .orElseThrow(resourceNotFound(departmentId));
        }
    }

    private Supplier<IllegalArgumentException> resourceNotFound(Integer departmentId) {
        return () ->
                new IllegalArgumentException(String.format("The DepartmentId: %d is not found!", departmentId));
    }
}