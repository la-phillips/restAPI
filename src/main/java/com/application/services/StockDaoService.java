package com.application.services;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;


import com.application.model.Stock;
import org.springframework.stereotype.Service;

@Service
public class StockDaoService implements StockService {
    private static Map<String, Stock> stocks = new HashMap<>(); // Will change to JPA/H2 database

    static {
        stocks.put("Apple", new Stock("AAPL", 120.00, LocalTime.now().truncatedTo(ChronoUnit.MINUTES).toString()));
//		stocks.add( new Stock.StockBuilder().withUpdatedAt().build());
        stocks.put("Microsoft", new Stock("MSFT", 50.00, LocalTime.now().truncatedTo(ChronoUnit.MINUTES).toString()));
        stocks.put("Gilead", new Stock("GILD", 97.66, LocalTime.now().truncatedTo(ChronoUnit.MINUTES).toString()));
    }

    public Map<String, Stock> findAll() {
        return stocks;
    }

    public Stock save(Stock stock) {
        if (stock.getSymbol() != null) {
            stock.setLastUpdated();
            stocks.put(stock.getSymbol(), stock);
        }
        return stock;
    }

    public Stock findOne(String symbol) {
        return stocks.get(symbol);
    }

    @Override
    public Stock deleteBySymbol(String symbol) {
        Stock stock = findOne(symbol);
        if (!(stock == null)) {
            stocks.remove(symbol);
            return stock;
        }
        return null;
    }
}
