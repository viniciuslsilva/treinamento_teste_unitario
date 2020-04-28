package br.com.tokenlab.treinamentotesteunitario.controller;

import br.com.tokenlab.treinamentotesteunitario.dto.DepartmentDTO;
import br.com.tokenlab.treinamentotesteunitario.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/department")
@RestController
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getDepartments() {
        return ResponseEntity.ok(departmentService.findAllDepartments());
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartmentDTO> getDepartment(@PathVariable Integer departmentId,
                                                       @RequestParam(required = false, defaultValue = "false") boolean includeEmployees,
                                                       @RequestParam(required = false, defaultValue = "false") boolean includeLocation) {
        return ResponseEntity.ok(departmentService.findDepartmentById(departmentId, includeEmployees, includeLocation));
    }

}