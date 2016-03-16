package com.example.impls.operations;

import com.example.abstracts.AbstractOpiration;
import com.example.interfaces.Storage;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Currency;

/**
 * Created by Mike on 16.03.2016.
 */
public class TransferOperation extends AbstractOpiration {
    private Storage fromeStorage;
    private Storage toStorage;
    private BigDecimal amount;
    private Currency currency;

    public TransferOperation(Storage fromeStorage, Storage toStorage, BigDecimal amount, Currency currency) {
        this.fromeStorage = fromeStorage;
        this.toStorage = toStorage;
        this.amount = amount;
        this.currency = currency;
    }

    public TransferOperation(long id, Calendar dateTime, String addInfo, Storage fromeStorage, Storage toStorage, BigDecimal amount, Currency currency) {
        super(id, dateTime, addInfo);
        this.fromeStorage = fromeStorage;
        this.toStorage = toStorage;
        this.amount = amount;
        this.currency = currency;
    }

    public TransferOperation(long id, Storage fromeStorage, Storage toStorage, BigDecimal amount, Currency currency) {
        super(id);
        this.fromeStorage = fromeStorage;
        this.toStorage = toStorage;
        this.amount = amount;
        this.currency = currency;
    }

    public Storage getFromeStorage() {
        return fromeStorage;
    }

    public void setFromeStorage(Storage fromeStorage) {
        this.fromeStorage = fromeStorage;
    }

    public Storage getToStorage() {
        return toStorage;
    }

    public void setToStorage(Storage toStorage) {
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
