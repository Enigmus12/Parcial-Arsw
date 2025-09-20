package eci.edu.co.arsw.model;

import java.util.Map;

public class PruebaModel {
        private String symbol;
    private Map<String, Double> intraday;
    private Map<String, Double> daily;
    private Map<String, Double> weekly;
    private Map<String, Double> monthly;

    public PruebaModel(String symbol) { this.symbol = symbol; }

    // Getters y setters
    public String getSymbol() { return symbol; }
    public void setSymbol(String symbol) { this.symbol = symbol; }
    public Map<String, Double> getIntraday() { return intraday; }
    public void setIntraday(Map<String, Double> intraday) { this.intraday = intraday; }
    public Map<String, Double> getDaily() { return daily; }
    public void setDaily(Map<String, Double> daily) { this.daily = daily; }
    public Map<String, Double> getWeekly() { return weekly; }
    public void setWeekly(Map<String, Double> weekly) { this.weekly = weekly; }
    public Map<String, Double> getMonthly() { return monthly; }
    public void setMonthly(Map<String, Double> monthly) { this.monthly = monthly; }
}
