package com.example.impls.operations;

import com.example.abstracts.AbstractOpiration;
import com.example.interfaces.Source;
import com.example.interfaces.Storage;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Currency;

/**
 * Created by Mike on 16.03.2016.
 */
public class IncomOperation extends AbstractOpiration {

    public IncomOperation(Source fromeSource, Storage toStorage, BigDecimal amount, Currency currency) {
        this.fromeSource = fromeSource;
        this.toStorage = toStorage;
        this.amount = amount;
        this.currency = currency;
    }

    public IncomOperation(long id, Calendar dateTime, String addInfo, Source fromeSource, Storage toStorage, BigDecimal amount, Currency currency) {
        super(id, dateTime, addInfo);
        this.fromeSource = fromeSource;
        this.toStorage = toStorage;
        this.amount = amount;
        this.currency = currency;
    }

    public IncomOperation(long id, Source fromeSource, Storage toStorage, BigDecimal amount, Currency currency) {
        super(id);
        this.fromeSource = fromeSource;
        this.toStorage = toStorage;
        this.amount = amount;
        this.currency = currency;
    }

    private Source fromeSource;
    private Storage toStorage;
    private BigDecimal amount;
    private Currency currency;

    public Source getFromeSource() {
        return fromeSource;
    }

    public void setFromeSource(Source fromeSource) {
        this.fromeSource = fromeSource;
    }

    public Storage getToStorage() {
        return toStorage;
    }

    public void setToStorage(Storage toStorage) {
        this.toStorage = toStorage;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
