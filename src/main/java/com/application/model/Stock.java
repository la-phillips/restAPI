package com.application.model;

import java.util.Objects;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Stock {

	private String symbol;
	private double price;
	private LocalTime lastUpdated;

	public Stock() {
		super();

	}

	public Stock(String symbol, double price) {
		super();
		this.symbol = symbol;
		this.price = price;
		this.lastUpdated = LocalTime.now().truncatedTo(ChronoUnit.MINUTES);
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

	public LocalTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalTime lastUpdated) {
		this.lastUpdated = LocalTime.now().truncatedTo(ChronoUnit.MINUTES);
	}

	@Override
	public String toString() {
		return "Stock [symbol=" + symbol + ", price=" + price + ", last updated at=" + lastUpdated + "]";
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
