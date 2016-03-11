package com.example.start;

import com.example.exceptions.CurrencyException;
import com.example.impls.DefaultStorage;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * Created by Mike on 11.03.2016.
 */
public class Main {
    public static void main(String[] args) {
        try {
            DefaultStorage storage = new DefaultStorage();
            Currency currencyUSD = Currency.getInstance("USD");
            Currency currencyRUB = Currency.getInstance("RUB");

            storage.addCurrency(currencyUSD);
            storage.addAmount(new BigDecimal(200), currencyUSD);
            System.out.println(storage.getAmount(currencyUSD));
        } catch (CurrencyException e) {
            e.printStackTrace();
        }
    }
}
