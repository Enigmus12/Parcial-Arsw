package eci.edu.co.arsw.service;

import eci.edu.co.arsw.model.PruebaModel;

/**
 * Interfaz para cualquier proveedor de datos de acciones.
 * Permite consultar el historial de una acción por su símbolo.
 */
public interface Provider {
    /**
     * Consulta el historial de una acción dada por su símbolo.
     * @param symbol Símbolo de la acción.
     * @return PruebaModel con los datos históricos.
     * @throws Exception Si ocurre un error en la consulta.
     */
    PruebaModel fetchStockHistory(String symbol) throws Exception;
}