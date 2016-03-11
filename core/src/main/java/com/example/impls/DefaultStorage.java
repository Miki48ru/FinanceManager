package com.example.impls;

import com.example.exceptions.AmountException;
import com.example.exceptions.CurrencyException;
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

    public DefaultStorage() {
    }

    public DefaultStorage(String name) {
        this.name = name;
    }

    public DefaultStorage(List<Currency> currencyList, String name, Map<Currency, BigDecimal> currencyAmounts) {
        this.currencyList = currencyList;
        this.name = name;
        this.currencyAmounts = currencyAmounts;
    }

    public DefaultStorage(Map<Currency, BigDecimal> currencyAmounts) {
        this.currencyAmounts = currencyAmounts;
    }

    public DefaultStorage(List<Currency> currencyList) {
        this.currencyList = currencyList;
    }

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
    public BigDecimal getAmount(Currency currency) throws CurrencyException {
        checkCurrencyExist(currency);
        return currencyAmounts.get(currency);
    }

    @Override
    public BigDecimal getApproxAmount(Currency currency) {
        // TODO реализовать расчет остатка с приведением в одну валюту
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void changeAmount(BigDecimal amount, Currency currency) throws CurrencyException {
        checkCurrencyExist(currency);
        currencyAmounts.put(currency, amount);
    }

    @Override
    public void addAmount(BigDecimal amount, Currency currency) throws CurrencyException {
        checkCurrencyExist(currency);
        BigDecimal oldAmount = currencyAmounts.get(currency);
        currencyAmounts.put(currency, oldAmount.add(amount));
    }

    private void checkCurrencyExist(Currency currency) throws CurrencyException {
        if (!currencyAmounts.containsKey(currency)){
            throw new CurrencyException("Currency "+ currency +" not Exist");
        }
    }

    @Override
    public void expenseAmount(BigDecimal amount, Currency currency) throws CurrencyException, AmountException{
        BigDecimal oldAmount = currencyAmounts.get(currency);
        BigDecimal newValue = oldAmount.subtract(amount);
        checkAmount(newValue);
        currencyAmounts.put(currency, newValue);
    }

    @Override
    public void addCurrency(Currency currency) throws CurrencyException {
        if (currencyAmounts.containsKey(currency)){
            throw new CurrencyException("Currency already exist");
        }
        currencyList.add(currency);
        currencyAmounts.put(currency, BigDecimal.ZERO);
    }

    @Override
    public void deleteCurrency(Currency currency) throws CurrencyException {
        checkCurrencyExist(currency);

        // не даем удалять валюту, если в хранилище есть деньги по этой валюте
        if (!currencyAmounts.get(currency).equals(BigDecimal.ZERO)){
            throw new CurrencyException("Can't delete currency with amount");
        }
        currencyAmounts.remove(currency);
        currencyList.remove(currency);
    }

    @Override
    public Currency getCurrency(String code) throws CurrencyException {


        // количество валют для каждого хранилища будет небольшим - поэтому можно провоить поиск через цикл
        // можно использовать библиотеку Apache Commons Collections

        for (Currency currency : currencyList) {
            if (currency.getCurrencyCode().equals(code)) {
                return currency;
            }
        }
        throw new CurrencyException("Currency (code="+code+") not exist in storage");
    }


    public void setCurrencyAmounts(Map<Currency, BigDecimal> currencyAmounts) {
        this.currencyAmounts = currencyAmounts;
    }

   private void checkAmount(BigDecimal amount) throws AmountException {
        if (amount.compareTo(BigDecimal.ZERO) < 0){
            throw new AmountException("Amount can't be < 0");
        }
    }

    @Override
    public List<Currency> getAvailableCurrencies() {
        return currencyList;
    }

    public void setAvailableCurrencies(List<Currency> availableCurrencies) {
        this.currencyList = availableCurrencies;
    }



}
