package com.prueba.ecommerce.servicio;

import com.prueba.ecommerce.config.ConfiguracionBD;
import com.prueba.ecommerce.dao.ProductoDAO;
import com.prueba.ecommerce.modelo.Producto;
import org.springframework.stereotype.Service; 

import java.util.List;

@Service 
public class ProductoServicio {
    private final ProductoDAO productoDAO;

    // El servicio selecciona la base de datos usando el Factory Method en ConfiguracionBD
    public ProductoServicio() {
        productoDAO = ConfiguracionBD.configureAdapterDB();
    }

    public void addProducto(Producto producto) {
        productoDAO.create(producto);
    }

    public Producto getProducto(int id) {
        return productoDAO.read(id);
    }

    public void updateProducto(Producto producto) {
        productoDAO.update(producto);
    }

    public void deleteProducto(int id) {
        productoDAO.delete(id);
    }

    public List<Producto> getAllProducts() {
        return productoDAO.getAllProducts();
    }
}
 