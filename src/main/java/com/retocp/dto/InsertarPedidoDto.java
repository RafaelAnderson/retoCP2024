package com.retocp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsertarPedidoDto {
    private Integer idCliente;
    private Integer idProducto;
    private Integer numeroPedido;
    private Integer cantidad;
}
