package com.example.impls;

import com.example.interfaces.Storage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mike on 10.03.2016.
 */
public class DefaultStorage implements Storage {

    private List<Currency> currencyList = new ArrayList<>();
    private String name;
    private Map<Currency, BigDecimal> currencyAmounts = new HashMap<Currency, BigDecimal>();

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public Map<Currency, BigDecimal> getCurrencyAmounts() {
        return currencyAmounts;
    }

    @Override
    public BigDecimal getAmount(Currency currency) {
        return currencyAmounts.get(currency);
    }

    @Override
    public BigDecimal getApproxAmount(Currency currency) {
        // TODO реализовать расчет остатка с приведением в одну валюту
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void changeAmount(BigDecimal amount, Currency currency) {
        currencyAmounts.put(currency, amount);
    }

    @Override
    public void addAmount(BigDecimal amount, Currency currency) {
        BigDecimal oldAmount = currencyAmounts.get(currency);
        currencyAmounts.put(currency, oldAmount.add(amount));
    }

    @Override
    public void expenseAmount(BigDecimal amount, Currency currency) {
        BigDecimal oldAmount = currencyAmounts.get(currency);
        BigDecimal newValue = oldAmount.subtract(amount);
        currencyAmounts.put(currency, newValue);
    }

    @Override
    public void addCurrency(Currency currency) {
        currencyList.add(currency);
        currencyAmounts.put(currency, BigDecimal.ZERO);
    }

    @Override
    public void deleteCurrency(Currency currency) {
        currencyAmounts.remove(currency);
        currencyList.remove(currency);
    }

    @Override
    public Currency getCurrency(String code) {
        // количество валют для каждого хранилища будет небольшим - поэтому можно провоить поиск через цикл
        // можно использовать библиотеку Apache Commons Collections

        for (Currency currency : currencyList) {
            if (currency.getCurrencyCode().equals(code)) {
                return currency;
            }
        }
        return null;
    }


    public void setCurrencyAmounts(Map<Currency, BigDecimal> currencyAmounts) {
        this.currencyAmounts = currencyAmounts;
    }



    @Override
    public List<Currency> getAvailableCurrencies() {
        return currencyList;
    }

    public void setAvailableCurrencies(List<Currency> availableCurrencies) {
        this.currencyList = availableCurrencies;
    }



}
