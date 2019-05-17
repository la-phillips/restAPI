package com.application.exception;

public class StockCannotBeFetchedException extends Exception {
    public StockCannotBeFetchedException(String message){
        super(message);
    }
}
