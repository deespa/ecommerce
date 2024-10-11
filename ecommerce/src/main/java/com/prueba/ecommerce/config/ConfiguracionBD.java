package com.prueba.ecommerce.config;

import com.prueba.ecommerce.dao.MySQLProductDAO;
import com.prueba.ecommerce.dao.OracleProductDAO;
import com.prueba.ecommerce.dao.ProductoDAO;

public class ConfiguracionBD {

    // Método Factory que devuelve una instancia de ProductoDAO según el tipo de base de datos.
    public static ProductoDAO configureAdapterDB() {
        String dbType = "Mysql"; // Se puede obtener de un archivo de configuración o variable de entorno
        
        if ("Mysql".equalsIgnoreCase(dbType)) {
            return new MySQLProductDAO();
        } else if ("Oracle".equalsIgnoreCase(dbType)) {
            return new OracleProductDAO();
        } else {
            throw new IllegalArgumentException("Tipo de base de datos no soportado.");
        }
    }
}
