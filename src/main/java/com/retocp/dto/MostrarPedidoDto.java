package com.retocp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MostrarPedidoDto {
    private String numeroPedido;
    private String nombreCliente;
    private String nombreProducto;
    private BigDecimal precioProducto;
    private Integer cantidadProducto;
    private BigDecimal precioTotal;
}
