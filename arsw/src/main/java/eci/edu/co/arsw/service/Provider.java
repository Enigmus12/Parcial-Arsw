package eci.edu.co.arsw.service;

import eci.edu.co.arsw.model.PruebaModel;

// Interfaz para cualquier proveedor de datos de acciones
public interface Provider {
    PruebaModel fetchStockHistory(String symbol) throws Exception;
}
