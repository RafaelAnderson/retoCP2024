package com.retocp.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class MostrarPedidoDto {
    private String numeroPedido;
    private String nombreCliente;
    private String nombreProducto;
    private BigDecimal precioProducto;
    private BigDecimal precioTotal;
}
