package com.retocp.service.impl;

import com.retocp.entity.Pedido;
import com.retocp.repository.PedidoRepository;
import com.retocp.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    public Pedido insert(Pedido p) {
        pedidoRepository.save(p);
        return p;
    }

    public Pedido update(Pedido p) {
        pedidoRepository.save(p);
        return p;
    }

    public Pedido get(Integer idPedido) {
        return pedidoRepository.findById(idPedido).orElseThrow();
    }

    public void delete(Integer idPedido) {
        Pedido pedido = pedidoRepository.findById(idPedido).orElseThrow();
        pedidoRepository.delete(pedido);
    }
}
