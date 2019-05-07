package com.application.model;


public class Stock {
	
	private String symbol ; 
	private Double price ; 
	private String updated_at ;
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	@Override
	public String toString() {
		return "Stock [symbol=" + symbol + ", price=" + price + ", updated_at=" + updated_at + "]";
	}
	public Stock(String symbol, Double price, String updated_at) {
		super();
		this.symbol = symbol;
		this.price = price;
		this.updated_at = updated_at;
	} 	
	
	
}
