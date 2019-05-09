package com.application.controllers;

import java.net.URI;
import java.util.Map;


import com.application.exception.StockNotFoundException;
import com.application.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.application.model.Stock;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class StockResource {
    private StockService service;

    @Autowired
    public StockResource(StockService service) {
        this.service = service;
    }

    @GetMapping("/stocks")
    public Map<String, Stock> retrieveAllStocks() {
        return service.findAll();
    }

    @GetMapping("/stocks/{symbol}")
    public Stock retrieveStock(@PathVariable String symbol) {
        Stock stock = service.findOne(symbol);
        if (stock == null)
            throw new StockNotFoundException("Symbol: " + symbol);

        return stock;
    }

    @PostMapping("/stocks")
    public ResponseEntity<Object> createStock(@RequestBody Stock stock) {
        Stock savedStock = service.save(stock);
        
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{symbol}")
                .buildAndExpand(savedStock.getSymbol()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/stocks/{symbol}")
    public void deleteStock(@PathVariable String symbol){
        Stock stock = service.deleteBySymbol(symbol);

        if(stock == null)
            throw new StockNotFoundException("Symbol: " + symbol);

    }
}
