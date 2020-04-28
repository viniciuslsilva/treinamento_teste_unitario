package br.com.tokenlab.treinamentotesteunitario.controller;

import br.com.tokenlab.treinamentotesteunitario.dto.DepartmentDTO;
import br.com.tokenlab.treinamentotesteunitario.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class DepartmentControllerTest {

    @Mock
    DepartmentService departmentService;

    @InjectMocks
    DepartmentController departmentController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(departmentController).build();
    }

    @Test
    void getDepartments() throws Exception {
        given(departmentService.findAllDepartments())
                .willReturn(Collections.singletonList(DepartmentDTO.builder()
                        .departmentId(1)
                        .departmentName("Marketing")
                        .build()));

        mockMvc.perform(get("/department"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].departmentId", is(1)))
                .andExpect(jsonPath("$[0].departmentName", is("Marketing")));

        then(departmentService).should(times(1)).findAllDepartments();
    }

    @Test
    void getDepartment() {
    }
}