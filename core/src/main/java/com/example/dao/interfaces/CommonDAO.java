package com.example.dao.interfaces;

import java.util.List;

/**
 * Created by Mike on 22.03.2016.
 */
public interface CommonDAO<T> {

    List<T> getAll();
    T get (long id);
    boolean update (T storage);
    boolean delete (T storage);

}
