package com.retocp.service.impl;

import com.retocp.dto.ActualizarPedido;
import com.retocp.dto.InsertarPedidoDto;
import com.retocp.dto.MostrarPedidoDto;
import com.retocp.entity.Cliente;
import com.retocp.entity.Pedido;
import com.retocp.entity.Producto;
import com.retocp.repository.PedidoRepository;
import com.retocp.repository.ProductoRepository;
import com.retocp.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ProductoRepository productoRepository;

    public Pedido insert(InsertarPedidoDto p) {
        Pedido pedido = Pedido.builder()
                .cliente(Cliente.builder().id(p.getIdCliente()).build())
                .producto(Producto.builder().id(p.getIdProducto()).build())
                .numero(p.getNumeroPedido())
                .cantidad(p.getCantidad())
                .build();
        pedidoRepository.save(pedido);
        return pedido;
    }

    public Pedido update(ActualizarPedido nuevoPedido) {
        Pedido pedido = pedidoRepository.findById(nuevoPedido.getIdPedido()).orElseThrow(RuntimeException::new);
        Producto producto = productoRepository.findById(nuevoPedido.getIdProducto()).orElseThrow();
        pedido.setCantidad(nuevoPedido.getCantidad());
        pedido.setProducto(producto);
        pedidoRepository.save(pedido);
        return pedido;
    }

    public MostrarPedidoDto get(Integer idPedido) {
        Pedido pedido = pedidoRepository.findById(idPedido).orElseThrow(RuntimeException::new);
        return MostrarPedidoDto.builder()
                .numeroPedido("Pedido Nro. ".concat(String.valueOf(pedido.getNumero())))
                .nombreCliente(pedido.getCliente().getNombres().concat(" ".concat(pedido.getCliente().getApellidos())))
                .nombreProducto(pedido.getProducto().getNombre())
                .precioProducto(pedido.getProducto().getPrecio())
                .cantidadProducto(pedido.getCantidad())
                .precioTotal(pedido.getProducto().getPrecio().multiply(BigDecimal.valueOf(pedido.getCantidad())))
                .build();
    }

    public void delete(Integer idPedido) {
        Pedido pedido = pedidoRepository.findById(idPedido).orElseThrow(RuntimeException::new);
        pedidoRepository.delete(pedido);
    }
}
