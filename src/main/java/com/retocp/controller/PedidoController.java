package com.retocp.controller;

import com.retocp.dto.ActualizarPedido;
import com.retocp.dto.InsertarPedidoDto;
import com.retocp.dto.MostrarPedidoDto;
import com.retocp.entity.Pedido;
import com.retocp.service.PedidoService;
import com.retocp.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<ApiResponse> insert(@RequestBody InsertarPedidoDto pedido) {
        Pedido p = pedidoService.insert(pedido);
        return ResponseEntity.ok(ApiResponse.ok("Pedido insertado", p));
    }

    @PutMapping
    public ResponseEntity<ApiResponse> update(@RequestBody ActualizarPedido nuevoPedido) {
        Pedido p = pedidoService.update(nuevoPedido);
        return ResponseEntity.ok(ApiResponse.ok("Pedido actualizado", p));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> getById(@PathVariable Integer id) {
        MostrarPedidoDto pedido = pedidoService.get(id);
        return ResponseEntity.ok(ApiResponse.ok("Pedido", pedido));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Integer id) {
        pedidoService.delete(id);
        return ResponseEntity.ok(ApiResponse.ok("Pedido eliminado", null));
    }
}
