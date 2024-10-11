package com.prueba.ecommerce.controller;

import com.prueba.ecommerce.modelo.Producto;
import com.prueba.ecommerce.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos") 
public class ControladorProducto {

    private final ProductoServicio productoServicio;

    @Autowired 
    public ControladorProducto(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    @PostMapping 
    public ResponseEntity<Void> addProducto(@RequestBody Producto producto) {
        productoServicio.addProducto(producto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}") 
    public Producto getProducto(@PathVariable int id) { 
        return productoServicio.getProducto(id);
    }

    @PutMapping
    public ResponseEntity<Void> updateProducto(@RequestBody Producto producto) {
        productoServicio.updateProducto(producto);
        return ResponseEntity.ok().build(); 
    }

    @DeleteMapping("/{id}") 
    public ResponseEntity<Void> deleteProducto(@PathVariable int id) {
        productoServicio.deleteProducto(id);
        return ResponseEntity.ok().build(); 
    }

    @GetMapping
    public List<Producto> getAllProducts() { 
        return productoServicio.getAllProducts();
    }
}
