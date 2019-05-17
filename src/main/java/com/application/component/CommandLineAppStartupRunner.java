package com.application.component;

import com.application.model.Stock;
import com.application.repository.StockRepository;
import com.application.services.StockService;
import com.application.services.StockServiceImpl;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private final StockRepository stockRepository;
    private final StockServiceImpl stockServiceImpl ;
    private final RestTemplate restTemplate;

    @Autowired
    public CommandLineAppStartupRunner(StockRepository stockRepository, StockServiceImpl stockServiceImpl,
                                       RestTemplate restTemplate) {
        this.stockRepository = stockRepository;
        this.stockServiceImpl = stockServiceImpl;
        this.restTemplate = restTemplate;
    }


    @Override
    public void run(String... args) {
//        ResponseEntity<Stock> stockEntity = restTemplate.getForEntity("https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=MSFT&apikey=demo", Stock.class);
//        stockServiceImpl.save(stockEntity.getBody());
//        System.out.println(stockEntity);
    }
}
