package com.application.services;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

import com.application.model.Stock;

@Component
public class StockDaoService {
	private static Map<String, Stock> stocks = new HashMap<>(); // Will change to JPA/H2 database 

	static {
		stocks.put("Apple", new Stock("AAPL", 120.00));
//		stocks.add( new Stock.StockBuilder().withUpdatedAt().build());
		stocks.put("Microsoft", new Stock("MSFT", 50.00));
		stocks.put("Gilead", new Stock("GILD", 97.66));
	}

	public Map<String, Stock> findAll() {
		return stocks;
	}

	public Stock save(Stock stock) {
		if (stock.getSymbol() != null)
			stocks.put(stock.getSymbol(), stock);
		return stock;
	}

	public Stock findOne(String symbol) {
		System.out.println(symbol);
		return stocks.get(symbol);
	}

}
