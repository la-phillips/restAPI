package com.application.controllers;

import java.util.Set;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.application.model.Stock;
import com.application.services.StockDaoService;

@RestController
public class DefaultController {
	
	@RequestMapping(method = RequestMethod.GET, path = "/stock/appl")
	public Set<Stock> getStock(String symbol) {
		return StockDaoService.stocks ; 
	}
}

