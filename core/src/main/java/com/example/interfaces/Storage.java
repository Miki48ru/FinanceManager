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
public interface Storage extends TreeNode{

    // получение баланса (остатка)
    Map<Currency, BigDecimal> getCurrencyAmounts(); // остаток по каждой доступной валюте в хранилище
    BigDecimal getAmount(Currency currency) throws CurrencyException; // остаток по определенной валюте
    BigDecimal getApproxAmount(Currency currency) throws CurrencyException;// примерный остаток в переводе всех денег в одну валюту

    // изменение баланса
    void updateAmount(BigDecimal amount, Currency currency) throws CurrencyException, AmountException; // изменение баланса по определенной валюте

    // работа с валютами (в отдельный интерфейс нет смысла выделять)
    Currency getCurrency(String code) throws CurrencyException;	// поулчить валюту по коду
    void addCurrency(Currency currency, BigDecimal initAmount) throws CurrencyException; // добавить новую валюту в хранилище с начальной суммой
    void deleteCurrency(Currency currency) throws CurrencyException; // удалить валюту из хранилища
    List<Currency> getAvailableCurrencies(); // получить все доступные валюты хранилища в отдельной коллекции

}
