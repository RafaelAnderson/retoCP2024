package com.retocp.controller;

import com.retocp.entity.Producto;
import com.retocp.service.ProductoService;
import com.retocp.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @PostMapping
    public ResponseEntity<ApiResponse> insert(@RequestBody Producto producto) {
        Producto p = productoService.insert(producto);
        return ResponseEntity.ok(ApiResponse.ok("Producto insertado", p));
    }

    @PostMapping(path = "/list")
    public ResponseEntity<ApiResponse> insertList(@RequestBody List<Producto> producto) {
        List<Producto> productoList = productoService.insertList(producto);
        return ResponseEntity.ok(ApiResponse.ok("Producto insertado", productoList));
    }

    @PutMapping
    public ResponseEntity<ApiResponse> put(@RequestBody Producto producto) {
        Producto p = productoService.update(producto);
        return ResponseEntity.ok(ApiResponse.ok("Producto actualizado", p));
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAll() {
        List<Producto> productoList = productoService.getAll();
        return ResponseEntity.ok(ApiResponse.ok("Listado de productos", productoList));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> get(@PathVariable Integer id) {
        Producto p = productoService.get(id);
        return ResponseEntity.ok(ApiResponse.ok("Producto", p));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Integer id) {
        productoService.delete(id);
        return ResponseEntity.ok(ApiResponse.ok("Producto eliminado", null));
    }
}
