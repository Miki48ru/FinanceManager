package com.example.interfaces;

import com.example.enums.OperationType;

import java.util.Calendar;

/**
 * Created by Mike on 04.04.2016.
 */
public interface Operation extends Comparable<Operation> {

    long getId();

    void setId(long id);

    OperationType getOperationType();

    Calendar getDateTime();

    String getDescription();
}


