package com.application.services;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.application.model.Stock;

@Component
public class StockDaoService {
	public static Set<Stock> stocks = new HashSet<>();

	
	static {
		stocks.add( new Stock("AAPL", 120.00, LocalTime.now().truncatedTo(ChronoUnit.MINUTES).toString() ));
//		stocks.add( new Stock.StockBuilder().withUpdatedAt().build());
		stocks.add( new Stock("MSFT", 50.00, LocalTime.now().truncatedTo(ChronoUnit.MINUTES).toString()));
		stocks.add( new Stock("IPIX", 0.29, LocalTime.now().truncatedTo(ChronoUnit.MINUTES).toString()));
	}
	
}
