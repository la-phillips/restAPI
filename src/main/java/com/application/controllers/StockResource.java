package com.application.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.application.model.Stock;
import com.application.services.StockDaoService;

@RestController
public class StockResource {
	
	@Autowired 
	private StockDaoService service ; 
	
	@RequestMapping(method = RequestMethod.GET, path = "/stocks")
	public Map<String, Stock> retrieveAllStocks(){
		return service.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, path= "/stocks/{symbol}")
	public Stock retrieveStock(@PathVariable String symbol) {
		return service.findOne(symbol);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/stocks" )
	public Stock createStock(@RequestBody Stock stock) {
		Stock savedStock = service.save(stock);
		System.out.println(service.findAll());
		return savedStock ; 
	}
}
