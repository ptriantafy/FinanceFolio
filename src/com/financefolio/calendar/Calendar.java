package com.financefolio.calendar;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;
import java.util.Date;

public class Calendar {
	
	//private String selection;
	private static List<Reminder> reminderList = new ArrayList<>();
	private static List<String> dayList = new ArrayList<>();
	

	
	public static void main(String[] args) {
		boolean running = true;
		String selection;
		
		
		 while(running) {
		 System.out.println("Welcome to Bill Reminder!\n");
		 Scanner sc = new Scanner(System.in);
		 
		
	     System.out.println("Please select a date to set a reminder(in YYYY-MM-DD format): ");
	     String DayNotifyBefore = sc.next();
	     sc.nextLine();
	     
	 	 int count = dayList.size(); 
	 	 int count2 = 0;
	        for (String item : dayList) {
	            if (item.equals(DayNotifyBefore)) {
	                count2++;
	            }
	        }
	        dayList.add(DayNotifyBefore);
	 	 
	        
	        if(count>1 && count2>=1) {
	 	         System.out.println("This day has  other reminders.\nYou want to set a reminder for bill or subscriptive expense(sub)?");
	 	    }
	 	    else  {
	 	    	System.out.println("This day has no other reminders.\nYou want to set a reminder for bill or subscriptive expense(sub)?");
	 	    }
	       
	        selection = sc.nextLine();
	        
	     
	       
	 
	        
	        
		 if (selection.equalsIgnoreCase("bill")) {
			 
			    Calendar calendar = new Calendar();
		        System.out.print("Enter the reminder body(the bill's description): ");
		        String body = sc.nextLine();
		        System.out.print("Enter the date of the bill payment (in YYYY-MM-DD format): ");
		        String date = sc.next();
		        System.out.print("Enter the hour you want to be notified in " + DayNotifyBefore + ": ");
		        String HourNotifyBefore = sc.next();
		        sc.nextLine();
		        Reminder reminder = new Reminder(body, DayNotifyBefore, HourNotifyBefore, date);
		        calendar.saveReminderToCalendar(reminder);
		        calendar.printReminderList(selection);
		        //dayList.remove(DayNotifyBefore);
		        
			 }		
		 
		 else if (selection.equalsIgnoreCase("sub")) {
			 
			    Calendar calendar = new Calendar();
		        System.out.print("Enter the reminder body(the expense's description): ");
		        String body = sc.nextLine();
		        System.out.print("Enter the date of the expense's first payment (in YYYY-MM-DD format): ");
		        String date = sc.next();
		        sc.nextLine();
		        System.out.println("Please select the frequency of the payment(daily, weekly, monthly, annual): ");
		        String payment_frequency = sc.nextLine();
		        Reminder reminder = new Reminder(body, payment_frequency,0, date);
		        
		         if(payment_frequency.equalsIgnoreCase("daily")) {
		        	 System.out.println("Do you want to be reminded every day? ");
		        	 String answer = sc.nextLine();
		        	 if(answer.equalsIgnoreCase("yes")) {
		        		 reminder.setFrequency(1);
		        		 calendar.saveReminderToCalendar(reminder);
		        		 calendar.printReminderList(selection); 
		        		 //dayList.remove(DayNotifyBefore);
		        		
		        	 }
		        	 else {
		        		 System.out.println("Describe how ofter you want to be reminded: ");
		        		 String answer2 = sc.nextLine();
		        		 reminder.setPayment_frequency(answer2);
		        		 System.out.println("Insert the desired frequency: ");
		        		 int answer3 = sc.nextInt();
		        		 reminder.setFrequency(answer3);
		        		 calendar.saveReminderToCalendar(reminder);
		        		 calendar.printReminderList(selection); 
		        		 //dayList.remove(DayNotifyBefore);
		            }
		        }
		         else if (payment_frequency.equalsIgnoreCase("weekly")){
		        	 System.out.println("Do you want to be reminded every week? ");
		        	 String answer = sc.nextLine();
		        	 if(answer.equalsIgnoreCase("yes")) {
		        		 reminder.setFrequency(7);
		        		 calendar.saveReminderToCalendar(reminder);
		        		 calendar.printReminderList(selection); 
		        		 //dayList.remove(DayNotifyBefore);
		        		
		        	 }
		        	 else {
		        		 System.out.println("Describe how ofter you want to be reminded: ");
		        		 String answer2 = sc.nextLine();
		        		 reminder.setPayment_frequency(answer2);
		        		 System.out.println("Insert the desired frequency: ");
		        		 int answer3 = sc.nextInt();
		        		 reminder.setFrequency(answer3);
		        		 calendar.saveReminderToCalendar(reminder);
		        		 calendar.printReminderList(selection); 
		        		 //dayList.remove(DayNotifyBefore);
		        		
		            }
		       }
		         else if (payment_frequency.equalsIgnoreCase("monthly")){
		        	 System.out.println("Do you want to be reminded every month? ");
		        	 String answer = sc.nextLine();
		        	 if(answer.equalsIgnoreCase("yes")) {
		        		 reminder.setFrequency(30);
		        		 calendar.saveReminderToCalendar(reminder);
		        		 calendar.printReminderList(selection); 
		        		 //dayList.remove(DayNotifyBefore);
		        		 
		        	 }
		        	 else {
		        		 System.out.println("Describe how ofter you want to be reminded: ");
		        		 String answer2 = sc.nextLine();
		        		 reminder.setPayment_frequency(answer2);
		        		 System.out.println("Insert the desired frequency: ");
		        		 int answer3 = sc.nextInt();
		        		 reminder.setFrequency(answer3);
		        		 calendar.saveReminderToCalendar(reminder);
		        		 calendar.printReminderList(selection); 
		        		 //dayList.remove(DayNotifyBefore);
		            }
		       }
		         else if (payment_frequency.equalsIgnoreCase("annual")){
		        	 System.out.println("Do you want to be reminded every year? ");
		        	 String answer = sc.nextLine();
		        	 if(answer.equalsIgnoreCase("yes")) {
		        		 reminder.setFrequency(365);
		        		 calendar.saveReminderToCalendar(reminder);
		        		 calendar.printReminderList(selection); 
		        		 //dayList.remove(DayNotifyBefore);
		        	 }
		        	 else {
		        		 System.out.println("Describe how ofter you want to be reminded: ");
		        		 String answer2 = sc.nextLine();
		        		 reminder.setPayment_frequency(answer2);
		        		 System.out.println("Insert the desired frequency: ");
		        		 int answer3 = sc.nextInt();
		        		 reminder.setFrequency(answer3);
		        		 calendar.saveReminderToCalendar(reminder);
		        		 calendar.printReminderList(selection); 
		        		 //dayList.remove(DayNotifyBefore);
		        		
		            }
		       }
		     }
		 System.out.println("Do you want to add another reminder?");
		 String option = sc.nextLine();
		 if (!option.equalsIgnoreCase("yes")) {
		        running = false; // Set the running flag to false to exit the loop
		    }
		 }
	}
		     
		 
		 
	
	
	
	
   
    public Calendar() {
        reminderList = new ArrayList<>();
    }

    public void saveReminderToCalendar(Reminder reminder) {
        reminderList.add(reminder);
    }
    
    public void saveDaytoCalendar(String day) {
    	dayList.add(day);
    	
    }

    public void updateReminder(Reminder reminder) {
 
        for (Reminder r : reminderList) {
            if (r.equals(reminder)) {
                r.setBody(reminder.getBody());
                r.setDayNotifyBefore(reminder.getDayNotifyBefore());
                r.setHourNotifyBefore(reminder.getHourNotifyBefore());
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
    
    public void printReminderList(String selection) {
        for (Reminder reminder : reminderList) {
        	System.out.println("------------------------");
            System.out.println("Reminder Body: " + reminder.getBody());
            if(selection.equals("bill")) {
            System.out.println("Notification set on: " + reminder.getDayNotifyBefore() + "\t" + reminder.getHourNotifyBefore());
            System.out.println("Date of bill's payment: " + reminder.getDate());
            }
            else {
            	System.out.println("Reminder set " + reminder.getPayment_frequency() + " (Reminder Frequency: " +  reminder.getFrequency() + ")");
            	
            	 System.out.println("Date of subscritive expense's first payment: " + reminder.getDate()); 	
            }
            System.out.println("------------------------");
        }
    }
    
    
}
