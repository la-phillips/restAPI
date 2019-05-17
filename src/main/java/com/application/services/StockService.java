package com.application.services;

import com.application.model.Stock;

import java.util.Optional;

public interface StockService {

    Stock save(Stock stock);

    Iterable<Stock> findAll();

    Stock deleteBySymbol(String symbol);

    Stock findBySymbol(String symbol);
}
