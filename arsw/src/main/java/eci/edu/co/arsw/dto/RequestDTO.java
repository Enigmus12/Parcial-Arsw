package eci.edu.co.arsw.dto;

/**
 * DTO para representar la solicitud de historial de una acción.
 * Incluye el símbolo de la acción y el intervalo de tiempo deseado.
 */
public class RequestDTO {
    private String symbol;
    private String interval; // intraday, daily, weekly, monthly

    /** @return Símbolo de la acción. */
    public String getSymbol() { return symbol; }
    /** @param symbol Símbolo de la acción. */
    public void setSymbol(String symbol) { this.symbol = symbol; }
    /** @return Intervalo solicitado. */
    public String getInterval() { return interval; }
    /** @param interval Intervalo solicitado. */
    public void setInterval(String interval) { this.interval = interval; }
}