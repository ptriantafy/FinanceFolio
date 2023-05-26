package com.financefolio.calendar;

import java.util.Date;

public class Reminder {
    private String body;
    private Date notifyBefore;
    private int frequency;
    private Date date;

    public Reminder(String body, Date notifyBefore, int frequency, Date date) {
        this.body = body;
        this.notifyBefore = notifyBefore;
        this.frequency = frequency;
        this.date = date;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getNotifyBefore() {
        return notifyBefore;
    }

    public void setNotifyBefore(Date notifyBefore) {
        this.notifyBefore = notifyBefore;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}