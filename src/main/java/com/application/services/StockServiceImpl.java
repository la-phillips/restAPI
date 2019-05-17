package com.application.services;

import com.application.exception.StockCannotBeFetchedException;
import com.application.exception.StockNotFoundException;
import com.application.model.Stock;
import com.application.repository.StockRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    private final String url;
    private final String symbolParameter;
    private final String apiKey;
    private final RestTemplate restTemplate;
    private final StockRepository stockRepository;
    private final List<String> seedStocks;

    @Autowired
    public StockServiceImpl(@Value("${LIVE_FEED_URL}") String url, @Value("${SYMBOL_PARAMETER}") String symbolParameter,
                            RestTemplate restTemplate, StockRepository stockRepository,
                            @Value("${LIVE_FEED_API_KEY}") String apiKey, @Value("${SEED_STOCKS}") String seedStocks) {
        this.url = url;
        this.symbolParameter = symbolParameter;
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
        this.stockRepository = stockRepository;
        this.seedStocks = Arrays.asList(seedStocks.split(","));
    }

    public JsonNode fetchStockData(String symbol) {
        String ApiEndPoint = url + symbolParameter + symbol + apiKey;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(ApiEndPoint, String.class);
        try {
            JsonNode jsonNode = new ObjectMapper().readTree(responseEntity.getBody());
            return jsonNode;
        } catch (IOException e) {
            return null;
        }
    }

//    public void populateDataBaseWithStocks(){
//        ListIterator<String> iterator= seedStocks.listIterator();
//        while(iterator.hasNext()){
//            JsonNode jsonNode = fetchStockData(iterator.next());
//            if(!(jsonNode == null)){
//                Stock stock = new Stock(jsonNode);
//                stockRepository.save(stock);
//            }
//        }
//    }

    @Override
    public Stock save(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Iterable<Stock> findAll() {
        return stockRepository.findAll();
    }

    @Override
    public Stock deleteBySymbol(String symbol) {
        return null;
    }

    @Override
    public Stock findBySymbol(String symbol) {
        try{
            Stock stock = getUpdatedData(symbol);
            return stockRepository.save(stock);
        }catch(StockCannotBeFetchedException e){
            if(!stockRepository.existsBySymbol(symbol))
                throw new StockNotFoundException("Stock could not be found");
            return stockRepository.findBySymbol(symbol);
        }
    }

    private Stock getUpdatedData(String symbol) throws StockCannotBeFetchedException {
        ResponseEntity<Stock> responseEntity = restTemplate.getForEntity(String.format("https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=%s&apikey=demo", symbol), Stock.class);

        if (!responseEntity.getStatusCode().equals(HttpStatus.OK))
            throw new StockCannotBeFetchedException("Stock cannot be fetched");

        return responseEntity.getBody();
    }

}
