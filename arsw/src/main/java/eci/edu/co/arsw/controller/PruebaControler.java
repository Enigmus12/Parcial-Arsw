package eci.edu.co.arsw.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eci.edu.co.arsw.dto.RequestDTO;
import eci.edu.co.arsw.dto.ResponseDTO;
import eci.edu.co.arsw.model.PruebaModel;
import eci.edu.co.arsw.service.StockService;


@RestController
@RequestMapping("/api/stocks")
public class PruebaControler {
    @Autowired
    private StockService stockService;

    @PostMapping("/history")
    public ResponseDTO getStockHistory(@RequestBody RequestDTO request) throws Exception {
        PruebaModel history = stockService.getStockHistory(request.getSymbol());
        Map<String, Double> result;
        switch (request.getInterval().toLowerCase()) {
            case "intraday": result = history.getIntraday(); break;
            case "daily": result = history.getDaily(); break;
            case "weekly": result = history.getWeekly(); break;
            case "monthly": result = history.getMonthly(); break;
            default: throw new IllegalArgumentException("Intervalo inválido");
        }
        return new ResponseDTO(request.getSymbol(), request.getInterval(), result);
    }
}
