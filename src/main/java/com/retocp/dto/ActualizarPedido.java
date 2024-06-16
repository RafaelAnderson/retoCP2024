package com.retocp.dto;

import lombok.Data;

@Data
public class ActualizarPedido {
    private Integer idPedido;
    private Integer idProducto;
    private Integer cantidad;
}
