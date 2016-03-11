package com.example.exceptions;

/**
 * Created by Mike on 11.03.2016.
 */
public class AmountException extends Exception {
    public AmountException() {
        super();
        //TODO Auto-generated constructor stub
    }

    public AmountException(String message) {
        super(message);
    }

    public AmountException(String message, Throwable cause) {
        super(message, cause);
    }

    public AmountException(Throwable cause) {
        super(cause);
    }

    public AmountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }
}
