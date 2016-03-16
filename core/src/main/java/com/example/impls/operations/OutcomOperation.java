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
public class OutcomOperation extends AbstractOpiration {


    public OutcomOperation(Storage fromeStorage, Source toStorage, BigDecimal amount, Currency currency) {
        this.fromeStorage = fromeStorage;
        this.toStorage = toStorage;
        this.amount = amount;
        this.currency = currency;
    }

    public OutcomOperation(long id, Calendar dateTime, String addInfo, Storage fromeStorage, Source toStorage, BigDecimal amount, Currency currency) {
        super(id, dateTime, addInfo);
        this.fromeStorage = fromeStorage;
        this.toStorage = toStorage;
        this.amount = amount;
        this.currency = currency;
    }

    public OutcomOperation(long id, Storage fromeStorage, Source toStorage, BigDecimal amount, Currency currency) {
        super(id);
        this.fromeStorage = fromeStorage;
        this.toStorage = toStorage;
        this.amount = amount;
        this.currency = currency;
    }

    private Storage fromeStorage;
    private Source toStorage;
    private BigDecimal amount;
    private Currency currency;

    public Storage getFromeStorage() {
        return fromeStorage;
    }

    public void setFromeStorage(Storage fromeStorage) {
        this.fromeStorage = fromeStorage;
    }

    public Source getToStorage() {
        return toStorage;
    }

    public void setToStorage(Source toStorage) {
        this.toStorage = toStorage;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
