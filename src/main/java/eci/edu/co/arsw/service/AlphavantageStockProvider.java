package eci.edu.co.arsw.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;
import eci.edu.co.arsw.model.PruebaModel;

/**
 * Proveedor de datos de acciones usando la API de Alphavantage.
 * Implementa la interfaz Provider y obtiene datos históricos en distintos intervalos.
 */
@Service
public class AlphavantageStockProvider implements Provider {
    @Value("${alphavantage.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * Consulta el historial completo de una acción y lo estructura en distintos intervalos.
     * @param symbol El símbolo de la acción.
     * @return PruebaModel con los datos intradía, diarios, semanales y mensuales.
     * @throws Exception Si ocurre un error en la consulta.
     */
    @Override
    public PruebaModel fetchStockHistory(String symbol) throws Exception {
        PruebaModel history = new PruebaModel(symbol);
        history.setIntraday(fetchHistory(symbol, "TIME_SERIES_INTRADAY", "5min"));
        history.setDaily(fetchHistory(symbol, "TIME_SERIES_DAILY", null));
        history.setWeekly(fetchHistory(symbol, "TIME_SERIES_WEEKLY", null));
        history.setMonthly(fetchHistory(symbol, "TIME_SERIES_MONTHLY", null));
        return history;
    }

    /**
     * Consulta los datos históricos desde Alphavantage según el tipo de serie.
     * @param symbol Símbolo de la acción.
     * @param function Función de la API (tipo de serie temporal).
     * @param interval Intervalo si aplica.
     * @return Mapa con las fechas y precios de cierre.
     * @throws Exception Si ocurre un error en la consulta.
     */
    private Map<String, Double> fetchHistory(String symbol, String function, String interval) throws Exception {
        String url = "https://www.alphavantage.co/query?function=" + function +
                "&symbol=" + symbol +
                (interval != null ? "&interval=" + interval : "") +
                "&apikey=" + apiKey;

        String result = restTemplate.getForObject(url, String.class);
        JSONObject json = new JSONObject(result);

        String key = "";
        if (function.equals("TIME_SERIES_INTRADAY")) key = "Time Series (" + interval + ")";
        if (function.equals("TIME_SERIES_DAILY")) key = "Time Series (Daily)";
        if (function.equals("TIME_SERIES_WEEKLY")) key = "Weekly Time Series";
        if (function.equals("TIME_SERIES_MONTHLY")) key = "Monthly Time Series";

        JSONObject timeSeries = json.getJSONObject(key);
        Map<String, Double> map = new HashMap<>();
        for (String date : timeSeries.keySet()) {
            double close = timeSeries.getJSONObject(date).getDouble("4. close");
            map.put(date, close);
        }
        return map;
    }
}