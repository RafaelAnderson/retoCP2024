package com.retocp.service;

import com.retocp.dto.ActualizarPedido;
import com.retocp.dto.InsertarPedidoDto;
import com.retocp.dto.MostrarPedidoDto;
import com.retocp.entity.Pedido;

public interface PedidoService {
    Pedido insert(InsertarPedidoDto pedido);

    Pedido update(ActualizarPedido nuevoPedido);

    MostrarPedidoDto get(Integer idPedido);

    void delete(Integer idPedido);
}
