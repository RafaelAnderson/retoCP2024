package com.retocp.service.impl;

import com.retocp.entity.Producto;
import com.retocp.repository.ProductoRepository;
import com.retocp.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    public Producto insert(Producto p) {
        productoRepository.save(p);
        return p;
    }

    public List<Producto> insertList(List<Producto> products) {
        List<Producto> list = new ArrayList<>();
        for(Producto p: products) {
            productoRepository.save(p);
            list.add(p);
        }
        return list;
    }

    public Producto update(Producto p) {
        productoRepository.save(p);
        return p;
    }

    public List<Producto> getAll() {
        return productoRepository.findAll();
    }

    public Producto get(Integer idProducto) {
        return productoRepository.findById(idProducto).orElseThrow();
    }

    public void delete(Integer idProducto) {
        Producto producto = productoRepository.findById(idProducto).orElseThrow();
        productoRepository.delete(producto);
    }
}
