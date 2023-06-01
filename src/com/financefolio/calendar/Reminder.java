package com.financefolio.calendar;

import java.util.Date;

public class Reminder {
    private String body;
    private String DayNotifyBefore;
    private String HourNotifyBefore;
    private String payment_frequency;
    private int frequency;
    private String date;
    
    
    public Reminder(String body, String payment_frequency, int frequency, String date) {
    	this.body = body;
    	this.payment_frequency = payment_frequency;
    	 this.frequency = frequency;
    	this.date = date;	
    }
    

    public Reminder(String body, String DayNotifyBefore, String HourNotifyBefore, String date) {
        this.body = body;
        this.DayNotifyBefore = DayNotifyBefore;
        this.HourNotifyBefore = HourNotifyBefore;
        this.date = date;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    public String getDayNotifyBefore() {
		return DayNotifyBefore;
	}

	public void setDayNotifyBefore(String dayNotifyBefore) {
		DayNotifyBefore = dayNotifyBefore;
	}

	public String getHourNotifyBefore() {
		return HourNotifyBefore;
	}

	public void setHourNotifyBefore(String hourNotifyBefore) {
		HourNotifyBefore = hourNotifyBefore;
	}

	public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}


	public String getPayment_frequency() {
		return payment_frequency;
	}


	public void setPayment_frequency(String payment_frequency) {
		this.payment_frequency = payment_frequency;
	}
	
	
    
    
    
   
}