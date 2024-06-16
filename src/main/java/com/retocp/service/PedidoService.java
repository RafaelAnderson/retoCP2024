package com.retocp.service;

import com.retocp.entity.Pedido;

public interface PedidoService {
    Pedido insert(Pedido pedido);

    Pedido update(Pedido pedido);

    Pedido get(Integer idPedido);

    void delete(Integer idPedido);
}
