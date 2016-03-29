package com.example.abstracts;

import java.util.Calendar;

/**
 * Created by Mike on 16.03.2016.
 */
public abstract class AbstractOpiration {
    private long id;
    private Calendar dateTime;
    private String addInfo;

    public AbstractOpiration() {
    }
    public AbstractOpiration(long id, Calendar dateTime, String addInfo) {
        this.id = id;
        this.dateTime = dateTime;
        this.addInfo = addInfo;
    }
    public AbstractOpiration(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Calendar getDateTime() {
        return dateTime;
    }

    public void setDateTime(Calendar dateTime) {
        this.dateTime = dateTime;
    }

    public String getAddInfo() {
        return addInfo;
    }

    public void setAddInfo(String addInfo) {
        this.addInfo = addInfo;
    }
}
