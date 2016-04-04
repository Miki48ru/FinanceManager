package com.example.impls.operations;

import com.example.abstracts.AbstractOperation;
import com.example.enums.OperationType;
import com.example.interfaces.Storage;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Currency;

/**
 * Created by Mike on 16.03.2016.
 */
public class ConvertOperation extends AbstractOperation {

    public ConvertOperation() {
        super(OperationType.CONVERT);
    }

    private Storage fromStorage; // откуда конвертируем
    private Storage toStorage; // куда конвертируем
    private Currency fromCurrency;// в какой валюте оправили деньги
    private Currency toCurrency; // в какой валюте получили деньги
    private BigDecimal fromAmount; // сумма отправки в первой валюте
    private BigDecimal toAmount; // сумма получения во второй валюте

    public Storage getFromStorage() {
        return fromStorage;
    }

    public void setFromStorage(Storage fromStorage) {
        this.fromStorage = fromStorage;
    }

    public Storage getToStorage() {
        return toStorage;
    }

    public void setToStorage(Storage toStorage) {
        this.toStorage = toStorage;
    }

    public Currency getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(Currency fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public Currency getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(Currency toCurrency) {
        this.toCurrency = toCurrency;
    }

    public BigDecimal getFromAmount() {
        return fromAmount;
    }

    public void setFromAmount(BigDecimal fromAmount) {
        this.fromAmount = fromAmount;
    }

    public BigDecimal getToAmount() {
        return toAmount;
    }

    public void setToAmount(BigDecimal toAmount) {
        this.toAmount = toAmount;
    }
}
