package eci.edu.co.arsw.dto;

import java.util.Map;

public class ResponseDTO {
    private String symbol;
    private String interval;
    private Map<String, Double> history;

    public ResponseDTO(String symbol, String interval, Map<String, Double> history) {
        this.symbol = symbol;
        this.interval = interval;
        this.history = history;
    }

    public String getSymbol() { return symbol; }
    public void setSymbol(String symbol) { this.symbol = symbol; }
    public String getInterval() { return interval; }
    public void setInterval(String interval) { this.interval = interval; }
    public Map<String, Double> getHistory() { return history; }
    public void setHistory(Map<String, Double> history) { this.history = history; }
}
