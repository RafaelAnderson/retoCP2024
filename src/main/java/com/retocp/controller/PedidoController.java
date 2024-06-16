package com.retocp.controller;

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
    public ResponseEntity<ApiResponse> insert(@RequestBody Pedido pedido) {
        Pedido p = pedidoService.insert(pedido);
        return ResponseEntity.ok(ApiResponse.ok("Pedido insertado", p));
    }

    @PutMapping
    public ResponseEntity<ApiResponse> put(@RequestBody Pedido pedido) {
        Pedido p = pedidoService.update(pedido);
        return ResponseEntity.ok(ApiResponse.ok("Pedido actualizado", p));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> get(@PathVariable Integer id) {
        Pedido p = pedidoService.get(id);
        return ResponseEntity.ok(ApiResponse.ok("Pedido", p));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Integer id) {
        pedidoService.delete(id);
        return ResponseEntity.ok(ApiResponse.ok("Pedido eliminado", null));
    }
}
