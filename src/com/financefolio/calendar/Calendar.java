package com.financefolio.calendar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calendar {
	
	public static void main(String[] args) {
		 System.out.println("Welcome to Bill Reminder!\n");
		 Scanner sc = new Scanner(System.in);
		 int choice;
		 do {
	     System.out.println("Please select a date: ");
		 choice = sc.nextInt();
		 }
		 while(choice>31);
		
		System.out.println("Select for what you want your reminder for. (Bill or subscriptive exprense)");
		String selection = sc.nextLine();
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
    private List<Reminder> reminderList;

    public Calendar() {
        reminderList = new ArrayList<>();
    }

    public void saveReminderToCalendar(Reminder reminder) {
        reminderList.add(reminder);
    }

    public void updateReminder(Reminder reminder) {
 
        for (Reminder r : reminderList) {
            if (r.equals(reminder)) {
                r.setBody(reminder.getBody());
                r.setNotifyBefore(reminder.getNotifyBefore());
                r.setFrequency(reminder.getFrequency());
                r.setDate(reminder.getDate());
                break;
            }
        }
    }

    public void deleteReminder(Reminder reminder) {
        reminderList.remove(reminder);
    }

    public List<Reminder> getReminderList() {
        return reminderList;
    }

    public void setReminderList(List<Reminder> reminderList) {
        this.reminderList = reminderList;
    }
    
    
    
}
