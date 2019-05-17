package com.application.repository;

import com.application.model.Stock;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<Stock, String> {

    Stock findBySymbol(String symbol);
    boolean existsBySymbol(String symbol);

}
