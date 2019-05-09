package com.application.services;

import com.application.model.Stock;

import java.util.Map;

public interface StockService {
    Stock save(Stock stock);

    Map<String, Stock> findAll();

    Stock findOne(String symbol);

    Stock deleteBySymbol(String symbol);
}
