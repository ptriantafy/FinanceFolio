package com.financefolio.calendar;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Reminder {
    private static final AtomicInteger count = new AtomicInteger(0); 
	private int reminder_id;
    private String body;
    private String DayNotifyBefore;
    private String HourNotifyBefore;
    private String payment_frequency;
    private int frequency;
    private String date;

    public Reminder(int reminder_id, String body, String DayNotifyBefore, String HourNotifyBefore, String payment_frequency, int frequency, String date) {
    	this.reminder_id = count.incrementAndGet();
        this.body = body;
        this.DayNotifyBefore = DayNotifyBefore;
        this.HourNotifyBefore = HourNotifyBefore;
        this.payment_frequency = payment_frequency;
   	    this.frequency = frequency;
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


	public int getReminder_id() {
		return reminder_id;
	}


	public void setReminder_id(int reminder_id) {
		this.reminder_id = reminder_id;
	}
	
	
    
    
    
   
}