package eci.edu.co.arsw.service;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eci.edu.co.arsw.model.PruebaModel;

/**
 * Servicio que gestiona la obtención y almacenamiento en caché del historial de acciones.
 */
@Service
public class StockService {
    @Autowired
    private Provider provider;

    // Cache tolerante a concurrencia para mejorar el rendimiento de las consultas repetidas.
    private final ConcurrentHashMap<String, PruebaModel> cache = new ConcurrentHashMap<>();

    /**
     * Obtiene el historial de una acción desde el cache o consultando el proveedor si no está en caché.
     * @param symbol Símbolo de la acción.
     * @return PruebaModel con el historial de la acción.
     * @throws Exception Si ocurre un error en la consulta al proveedor.
     */
    public PruebaModel getStockHistory(String symbol) throws Exception {
        if (cache.containsKey(symbol)) {
            return cache.get(symbol);
        }
        PruebaModel history = provider.fetchStockHistory(symbol);
        cache.put(symbol, history);
        return history;
    }
}