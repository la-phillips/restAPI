package com.application.model;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Objects;

public class Stock {

	private String symbol;
	private double price;
	private String updatedAt;

	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stock(String symbol, double price, String updatedAt) {
		super();
		this.symbol = symbol;
		this.price = price;
		this.updatedAt = updatedAt ; 
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Stock [symbol=" + symbol + ", price=" + price + ", updated_at=" + updatedAt + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null)
			return false;

		if (getClass() != o.getClass())
			return false;

		Stock stock = (Stock) o;

		return Objects.equals(symbol, stock.symbol);
	}

	@Override
	public int hashCode() {
		return Objects.hash(symbol);
	}

//	public static class StockBuilder {
//
//		private Stock stock;
//		
//		public StockBuilder withUpdatedAt() {
//			stock.setUpdatedAt(LocalTime.now(timeZone));
//			return this;
//		}
//
//		public Stock build() {
//			Stock copy = new Stock();
//			copy.setSymbol(stock.getSymbol());
//
//			return copy;
//		}
//
//	}
}
