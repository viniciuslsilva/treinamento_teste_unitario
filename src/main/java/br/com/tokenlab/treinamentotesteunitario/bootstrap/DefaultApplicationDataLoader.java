package br.com.tokenlab.treinamentotesteunitario.bootstrap;

import br.com.tokenlab.treinamentotesteunitario.domain.Department;
import br.com.tokenlab.treinamentotesteunitario.domain.Employee;
import br.com.tokenlab.treinamentotesteunitario.repository.DepartmentRepository;
import br.com.tokenlab.treinamentotesteunitario.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DefaultApplicationDataLoader implements CommandLineRunner {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) {
        loadApplicationData();
    }


    private void loadApplicationData() {
        if (departmentRepository.count() == 0) {
            Department marketing = departmentRepository.save(Department
                    .builder()
                    .departmentName("Marketing")
                    .build());

            employeeRepository.save(Employee
                    .builder()
                    .firstName("Thiago")
                    .lastName("Silva")
                    .email("thiagosilva@raccoon.com.br")
                    .department(marketing)
                    .build());

            employeeRepository.save(Employee
                    .builder()
                    .firstName("João")
                    .lastName("Pereira")
                    .email("joaopereira@raccoon.com.br")
                    .department(marketing)
                    .build());

            Department development = departmentRepository.save(Department
                    .builder()
                    .departmentName("Development")
                    .build());

            employeeRepository.save(Employee
                    .builder()
                    .firstName("Fabio")
                    .lastName("Rodrigo")
                    .email("fabiorodrigo@tokenlab.com.br")
                    .department(development)
                    .build());

            employeeRepository.save(Employee
                    .builder()
                    .firstName("Douglas")
                    .lastName("Rodriguez")
                    .email("douglasrodrigues@tokenlab.com.br")
                    .department(development)
                    .build());

        }
    }
}
