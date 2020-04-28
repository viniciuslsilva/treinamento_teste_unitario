package br.com.tokenlab.treinamentotesteunitario.repository;

import br.com.tokenlab.treinamentotesteunitario.domain.Employee;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Override
    @EntityGraph(attributePaths = {"department", "department.location"})
    List<Employee> findAll();

}
