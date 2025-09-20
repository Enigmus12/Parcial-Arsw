package eci.edu.co.arsw.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import eci.edu.co.arsw.model.PruebaModel;

@Service
public class AlphavantageStockProvider implements Provider {
    @Value("${alphavantage.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public PruebaModel fetchStockHistory(String symbol) throws Exception {
        PruebaModel history = new PruebaModel(symbol);
        history.setIntraday(fetchHistory(symbol, "TIME_SERIES_INTRADAY", "5min"));
        history.setDaily(fetchHistory(symbol, "TIME_SERIES_DAILY", null));
        history.setWeekly(fetchHistory(symbol, "TIME_SERIES_WEEKLY", null));
        history.setMonthly(fetchHistory(symbol, "TIME_SERIES_MONTHLY", null));
        return history;
    }

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
