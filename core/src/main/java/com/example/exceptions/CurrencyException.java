package com.example.exceptions;

/**
 * Created by Mike on 11.03.2016.
 */
public class CurrencyException extends Exception {
    public CurrencyException() {
        super();
    }

    public CurrencyException(String message) {
        super(message);
    }

    public CurrencyException(String message, Throwable cause) {
        super(message, cause);
    }

    public CurrencyException(Throwable cause) {
        super(cause);
    }

    public CurrencyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
