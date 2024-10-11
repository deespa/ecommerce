package com.prueba.ecommerce.dao;

import com.prueba.ecommerce.modelo.Producto;
import java.util.ArrayList;
import java.util.List;

public class MySQLProductDAO implements ProductoDAO {
    private List<Producto> productos = new ArrayList<>();

    public MySQLProductDAO() {
        productos.add(new Producto(1, "Guitarra", 130000));
        productos.add(new Producto(2, "Bateria", 250000));
    }

    @Override
    public void create(Producto producto) {
        productos.add(producto);
    }

    @Override
    public Producto read(int id) {
        return productos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void update(Producto producto) {
       
    }

    @Override
    public void delete(int id) {
        productos.removeIf(p -> p.getId() == id);
    }

    @Override
    public List<Producto> getAllProducts() {
        return productos;
    }
}
