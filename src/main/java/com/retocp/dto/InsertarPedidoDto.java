package com.retocp.dto;

import lombok.Data;

@Data
public class InsertarPedidoDto {
    private Integer idCliente;
    private Integer idProducto;
    private Integer numeroPedido;
    private Integer cantidad;
}
