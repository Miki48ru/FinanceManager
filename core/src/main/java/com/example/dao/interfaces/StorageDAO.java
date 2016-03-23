package com.example.dao.interfaces;

import com.example.interfaces.Storage;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * Created by Mike on 22.03.2016.
 */
public interface StorageDAO extends CommonDAO<Storage> {

    boolean addCurrency(Storage storage, Currency currency);
    boolean deleteCurrency (Storage storage, Currency currency);
    boolean updateAmount(Storage storage, BigDecimal amount);
}
