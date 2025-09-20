package eci.edu.co.arsw.service;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eci.edu.co.arsw.model.PruebaModel;

@Service
public class StockService {
    @Autowired
    private Provider provider;

    // Cache tolerante a concurrencia
    private final ConcurrentHashMap<String, PruebaModel> cache = new ConcurrentHashMap<>();

    public PruebaModel getStockHistory(String symbol) throws Exception {
        if (cache.containsKey(symbol)) {
            return cache.get(symbol);
        }
        PruebaModel history = provider.fetchStockHistory(symbol);
        cache.put(symbol, history);
        return history;
    }
}