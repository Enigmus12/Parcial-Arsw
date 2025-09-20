package eci.edu.co.arsw.dto;

public class RequestDTO {
    private String symbol;
    private String interval; // intraday, daily, weekly, monthly

    public String getSymbol() { return symbol; }
    public void setSymbol(String symbol) { this.symbol = symbol; }
    public String getInterval() { return interval; }
    public void setInterval(String interval) { this.interval = interval; }
}

