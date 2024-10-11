package com.prueba.ecommerce.dao;

import com.prueba.ecommerce.modelo.Producto;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OracleProductDAO implements ProductoDAO {
    private Map<Integer, Producto> productos = new HashMap<>();

    public OracleProductDAO() {
       
        productos.put(1, new Producto(1, "Guitarra", 130000));
        productos.put(2, new Producto(2, "Bateria", 250000));
    }

    @Override
    public void create(Producto producto) {
        productos.put(producto.getId(), producto);
    }

    @Override
    public Producto read(int id) {
        return productos.get(id);
    }

    @Override
    public void update(Producto producto) {
        productos.put(producto.getId(), producto);
    }
 
    @Override
    public void delete(int id) {
        productos.remove(id);
    }

    @Override
    public List<Producto> getAllProducts() {
        return productos.values().stream().collect(Collectors.toList());
    }
}
