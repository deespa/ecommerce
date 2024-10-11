package com.prueba.ecommerce;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.prueba.ecommerce.controller.ControladorProducto;
import com.prueba.ecommerce.modelo.Producto;

@SpringBootApplication
public class EcommerceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(ControladorProducto controladorProducto) {
        return args -> {
            controladorProducto.addProducto(new Producto(3, "Acordeon", 200000));
            controladorProducto.addProducto(new Producto(4, "Caja", 80000));

            System.out.println("Todos los productos:");
            controladorProducto.getAllProducts().forEach(p -> 
                System.out.println("ID: " + p.getId() + ", Descripcion: " + p.getDescripcion()));
        };
    }
}
