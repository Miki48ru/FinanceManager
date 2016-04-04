package com.example.dao.interfaces;

import com.example.exceptions.CurrencyException;
import com.example.interfaces.Storage;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * Created by Mike on 22.03.2016.
 */
public interface StorageDAO extends CommonDAO<Storage> {

    // boolean - чтобы удостовериться, что операция прошла успешно
    boolean addCurrency(Storage storage, Currency currency, BigDecimal initAmount) throws CurrencyException;
    boolean deleteCurrency(Storage storage, Currency currency) throws CurrencyException;
    boolean updateAmount(Storage storage, Currency currency, BigDecimal amount);// сюда входит прибавить, отнять и обновить

    boolean add(Storage storage);
}
