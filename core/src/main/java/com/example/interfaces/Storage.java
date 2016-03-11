package com.example.interfaces;

import com.example.exceptions.AmountException;
import com.example.exceptions.CurrencyException;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.Map;

/**
 * Created by Mike on 09.03.2016.
 */
public interface Storage {



    String getName();

    //получение баланса

    Map<Currency, BigDecimal> getCurrencyAmounts();

    BigDecimal getAmount(Currency currency) throws CurrencyException;
    BigDecimal getApproxAmount(Currency currency) throws CurrencyException;





    //изменение баланса



    void changeAmount(BigDecimal amount, Currency currency) throws CurrencyException; //изменение баланса по валюте
    void addAmount(BigDecimal amount, Currency currency) throws CurrencyException; //добавить сумму в валюте
    void expenseAmount(BigDecimal amount, Currency currency) throws CurrencyException, AmountException; //отнять сумму в валюте




    //работа с валютой

    void addCurrency(Currency currency) throws CurrencyException;

    void deleteCurrency(Currency currency) throws CurrencyException;

    Currency getCurrency(String code) throws CurrencyException;

    List<Currency> getAvailableCurrencies();



}
