package com.application.model;

import javax.validation.constraints.Size;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Stock {

    @Size(min = 1, message = "symbol should have at least 1 character")
    private String symbol;
    private double price;
    private String lastUpdated;

    @SuppressWarnings("unused")
    public Stock() {
        super();
    }

    public Stock(String symbol, double price, String lastUpdated) {
        super();
        this.symbol = symbol;
        this.price = price;
        this.lastUpdated = lastUpdated;
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

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated() {
        this.lastUpdated = LocalTime.now().truncatedTo(ChronoUnit.MINUTES).toString();
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
