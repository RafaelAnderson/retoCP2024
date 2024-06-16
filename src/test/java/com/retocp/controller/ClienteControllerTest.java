package com.retocp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.retocp.dto.RegistroClienteDto;
import com.retocp.entity.Cliente;
import com.retocp.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class ClienteControllerTest {

    @Mock
    private ClienteService clienteService;

    @InjectMocks
    private ClienteController clienteController;
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(clienteController).build();
    }

    @Test
    @DisplayName("Método 'insert'")
    void insert() throws Exception {
        RegistroClienteDto dto = RegistroClienteDto.builder()
                .nombres("Rafael")
                .apellidos("Ponte G.")
                .direccion("Perú")
                .username("RAFAEL")
                .password("RAFAEL12345")
                .build();

        Cliente c = Cliente.builder()
                .id(1)
                .nombres("Rafael")
                .apellidos("Ponte G.")
                .direccion("Perú")
                .build();
        given(clienteService.insert(any(RegistroClienteDto.class))).willReturn(c);

        String request = objectMapper.writeValueAsString(dto);
        MockHttpServletRequestBuilder mock = post("/api/cliente/register");
        MockHttpServletRequestBuilder requestBuilder = mock.contentType(MediaType.APPLICATION_JSON)
                .content(request);
        ResultActions resultActions = mockMvc.perform(requestBuilder);

        verify(clienteService).insert(any(RegistroClienteDto.class));
        resultActions.andExpect(status().isOk());
    }
}
