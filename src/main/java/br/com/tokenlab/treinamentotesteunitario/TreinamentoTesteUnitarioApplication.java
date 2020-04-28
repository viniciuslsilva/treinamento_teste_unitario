package br.com.tokenlab.treinamentotesteunitario;

import br.com.tokenlab.treinamentotesteunitario.domain.Department;
import br.com.tokenlab.treinamentotesteunitario.dto.DepartmentDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManagerFactory;

@SpringBootApplication
public class TreinamentoTesteUnitarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(TreinamentoTesteUnitarioApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(EntityManagerFactory emFactory) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration()
				.setPropertyCondition(context -> emFactory.getPersistenceUnitUtil().isLoaded(context.getSource()));
		mapper.typeMap(Department.class, DepartmentDTO.class)
				.addMappings(new PropertyMap<Department, DepartmentDTO>() {
			@Override
			protected void configure() {
				map().setLocation(null);
			}
		});
		return mapper;
	}
}
