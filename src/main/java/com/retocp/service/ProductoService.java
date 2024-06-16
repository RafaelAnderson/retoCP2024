package com.retocp.service;

import com.retocp.entity.Producto;

import java.util.List;

public interface ProductoService {
    Producto insert(Producto producto);

    List<Producto> insertList(List<Producto> producto);

    Producto update(Producto producto);

    List<Producto> getAll();

    Producto get(Integer idProducto);

    void delete(Integer idProducto);
}
