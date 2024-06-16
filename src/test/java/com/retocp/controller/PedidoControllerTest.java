package com.retocp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.retocp.dto.ActualizarPedido;
import com.retocp.dto.InsertarPedidoDto;
import com.retocp.dto.MostrarPedidoDto;
import com.retocp.entity.Pedido;
import com.retocp.service.PedidoService;
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

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class PedidoControllerTest {

    @Mock
    private PedidoService pedidoService;

    @InjectMocks
    private PedidoController pedidoController;
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(pedidoController).build();
    }

    @Test
    @DisplayName("Método 'insert'")
    void insert() throws Exception {
        InsertarPedidoDto dto = InsertarPedidoDto.builder()
                .idCliente(1)
                .idProducto(1)
                .numeroPedido(100000)
                .cantidad(2)
                .build();

        Pedido p = Pedido.builder()
                .id(1)
                .numero(1000)
                .cantidad(2)
                .build();

        given(pedidoService.insert(any(InsertarPedidoDto.class))).willReturn(p);

        String request = objectMapper.writeValueAsString(dto);
        MockHttpServletRequestBuilder mock = post("/api/pedido");
        MockHttpServletRequestBuilder requestBuilder = mock.contentType(MediaType.APPLICATION_JSON)
                .content(request);
        ResultActions resultActions = mockMvc.perform(requestBuilder);

        verify(pedidoService).insert(any(InsertarPedidoDto.class));
        resultActions.andExpect(status().isOk());
    }

    @Test
    @DisplayName("Método 'update'")
    void update() throws Exception {
        ActualizarPedido dto = ActualizarPedido.builder()
                .idPedido(1)
                .idProducto(3)
                .cantidad(4)
                .build();

        Pedido p = Pedido.builder()
                .id(1)
                .numero(1000)
                .cantidad(2)
                .build();
        given(pedidoService.update(any(ActualizarPedido.class))).willReturn(p);

        String request = objectMapper.writeValueAsString(dto);
        MockHttpServletRequestBuilder mock = put("/api/pedido");
        MockHttpServletRequestBuilder requestBuilder = mock.contentType(MediaType.APPLICATION_JSON)
                .content(request);
        ResultActions resultActions = mockMvc.perform(requestBuilder);

        verify(pedidoService).update(any(ActualizarPedido.class));
        resultActions.andExpect(status().isOk());
    }

    @Test
    @DisplayName("Método 'getById'")
    void getById() throws Exception {
        MostrarPedidoDto dto = MostrarPedidoDto.builder()
                .numeroPedido("100000")
                .nombreCliente("Rafael Ponte")
                .precioProducto(BigDecimal.valueOf(2000))
                .precioTotal(BigDecimal.valueOf(2000))
                .build();
        given(pedidoService.get(anyInt())).willReturn(dto);

        MockHttpServletRequestBuilder mock = get("/api/pedido/1");
        MockHttpServletRequestBuilder requestBuilder = mock.contentType(MediaType.APPLICATION_JSON);
        ResultActions resultActions = mockMvc.perform(requestBuilder);

        verify(pedidoService).get(anyInt());
        resultActions.andExpect(status().isOk());
    }

    @Test
    @DisplayName("Método 'delete'")
    void eliminarPedido() throws Exception {

        MockHttpServletRequestBuilder mock = delete("/api/pedido/1");
        MockHttpServletRequestBuilder requestBuilder = mock.contentType(MediaType.APPLICATION_JSON);
        ResultActions resultActions = mockMvc.perform(requestBuilder);

        verify(pedidoService).delete(anyInt());
        resultActions.andExpect(status().isOk());
    }
}
