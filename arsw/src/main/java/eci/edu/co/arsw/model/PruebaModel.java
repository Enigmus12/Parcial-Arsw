package eci.edu.co.arsw.model;

import java.util.Map;

/**
 * Modelo que representa el historial de precios de una acción.
 * Almacena datos para diferentes intervalos: intraday, daily, weekly y monthly.
 */
public class PruebaModel {
    private String symbol;
    private Map<String, Double> intraday;
    private Map<String, Double> daily;
    private Map<String, Double> weekly;
    private Map<String, Double> monthly;

    /**
     * Constructor con símbolo de la acción.
     * @param symbol El símbolo de la acción.
     */
    public PruebaModel(String symbol) { this.symbol = symbol; }

    // Getters y setters
    /** @return El símbolo de la acción. */
    public String getSymbol() { return symbol; }
    /** @param symbol El símbolo de la acción. */
    public void setSymbol(String symbol) { this.symbol = symbol; }
    /** @return Historial intradía. */
    public Map<String, Double> getIntraday() { return intraday; }
    /** @param intraday Historial intradía. */
    public void setIntraday(Map<String, Double> intraday) { this.intraday = intraday; }
    /** @return Historial diario. */
    public Map<String, Double> getDaily() { return daily; }
    /** @param daily Historial diario. */
    public void setDaily(Map<String, Double> daily) { this.daily = daily; }
    /** @return Historial semanal. */
    public Map<String, Double> getWeekly() { return weekly; }
    /** @param weekly Historial semanal. */
    public void setWeekly(Map<String, Double> weekly) { this.weekly = weekly; }
    /** @return Historial mensual. */
    public Map<String, Double> getMonthly() { return monthly; }
    /** @param monthly Historial mensual. */
    public void setMonthly(Map<String, Double> monthly) { this.monthly = monthly; }
}