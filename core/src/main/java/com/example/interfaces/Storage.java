package com.example.interfaces;

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

    BigDecimal getAmount(Currency currency);
    BigDecimal getApproxAmount(Currency currency);

    //изменение баланса

    void changeAmount(BigDecimal amount, Currency currency); //изменение баланса по валюте
    void addAmount(BigDecimal amount, Currency currency); //добавить сумму в валюте
    void expenseAmount(BigDecimal amount, Currency currency); //отнять сумму в валюте



    //работа с валютой

    void addCurrency(Currency currency);

    void deleteCurrency(Currency currency);

    Currency getCurrency(String code);

    List<Currency> getAvailableCurrencies();



}
