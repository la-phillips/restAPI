package com.application.controllers;

import com.application.exception.StockNotFoundException;
import com.application.model.Stock;
import com.application.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@RestController
public class StockController {
    private StockService service;

    @Autowired
    public StockController(StockService service) {
        this.service = service;
    }

    @GetMapping("/jpa/stocks")
    public Iterable<Stock> retrieveAllStocks() {
        return service.findAll();
    }

    @GetMapping(value = "/jpa/stocks/{symbol}")
    public Stock retrieveStock(@PathVariable String symbol) {
        return service.findBySymbol(symbol);
    }

    @PostMapping("/jpa/stocks")
    public ResponseEntity<Object> createStock(@Valid @RequestBody Stock stock) {
        Stock savedStock = service.save(stock);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{symbol}")
                .buildAndExpand(savedStock.getSymbol()).toUri();

         return  ResponseEntity.created(location).build();

    }

    @DeleteMapping("/stocks/{symbol}")
    public void deleteStock(@PathVariable String symbol) {
        service.deleteBySymbol(symbol);
    }

}
