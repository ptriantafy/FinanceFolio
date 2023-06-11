package com.financefolio.calendar;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;
import java.util.Date;

public class Calendar {
	
	private static int calendar_id;
	//private String selection;
	private static List<Reminder> reminderList = new ArrayList<>();
	private static List<String> dayList = new ArrayList<>();
	

	
	public static void main(String[] args) {
		boolean running = true;
		String selection;
		 int calendar_count = 0;
		
		
		
		 Calendar calendar = new Calendar();
		 System.out.println("Welcome to Bill Reminder!\n");
		 Scanner sc = new Scanner(System.in);
		 
		 while(running) {
			 
			
	     System.out.println("Please select a date (in YYYY-MM-DD format): ");
	     String DayNotifyBefore = sc.next();
	     
	     if(!dayList.contains(DayNotifyBefore)){
	    	
	    	 calendar_count++;
	    	calendar.setCalendar_id(calendar_count);
	    	
	     }
	     sc.nextLine();
	     
	 	 int count = dayList.size(); 
	 	 int count2 = 0;
	        for (String item : dayList) {
	            if (item.equals(DayNotifyBefore)) {
	                count2++;
	            }
	        }
	        dayList.add(DayNotifyBefore);
	        
	        System.out.println("Do you want to set, delete or update a reminder? ");
	        String desicion = sc.nextLine();
	        
	        if(desicion.equalsIgnoreCase("set")) {
	 	 
	        
	        if(count>=1 && count2>=1) {
	 	         System.out.println("This day has  other reminders.\nYou want to set a reminder for bill or subscriptive expense(sub)?");
	 	    }
	 	    else  {
	 	    	System.out.println("This day has no other reminders.\nYou want to set a reminder for bill or subscriptive expense(sub)?");
	 	    }
	       
	        selection = sc.nextLine();
	       
	     
	       
	 
	        
	        
		 if (selection.equalsIgnoreCase("bill")) {
			 
			    
		        System.out.print("Enter the reminder body(the bill's description): ");
		        String body = sc.nextLine();
		        System.out.print("Enter the date of the bill payment (in YYYY-MM-DD format): ");
		        String date = sc.next();
		        System.out.print("Enter the hour you want to be notified in " + DayNotifyBefore + ": ");
		        String HourNotifyBefore = sc.next();
		        sc.nextLine();
		        Reminder reminder = new Reminder(0, body, DayNotifyBefore, HourNotifyBefore, "", 0, date);
		        calendar.saveReminderToCalendar(reminder);
		        calendar.printReminderList(selection, reminder);
		        
			 }		
		 
		 else if (selection.equalsIgnoreCase("sub")) {
			 
			 
		        System.out.print("Enter the reminder body(the expense's description): ");
		        String body = sc.nextLine();
		        System.out.print("Enter the date of the expense's first payment (in YYYY-MM-DD format): ");
		        String date = sc.next();
		        sc.nextLine();
		        System.out.println("Please select the frequency of the payment(daily, weekly, monthly, annual): ");
		        String payment_frequency = sc.nextLine();
		        Reminder reminder = new Reminder(0, body, "", "", payment_frequency,0, date);
		        
		         if(payment_frequency.equalsIgnoreCase("daily")) {
		        	 System.out.println("Do you want to be reminded every day? ");
		        	 String answer = sc.nextLine();
		        	 if(answer.equalsIgnoreCase("yes")) {
		        		 reminder.setFrequency(1);
		        		 calendar.saveReminderToCalendar(reminder);
		        		 calendar.printReminderList(selection, reminder); 
		        		
		        	 }
		        	 else {
		        		 System.out.println("Describe how ofter you want to be reminded: ");
		        		 String answer2 = sc.nextLine();
		        		 reminder.setPayment_frequency(answer2);
		        		 System.out.println("Insert the desired frequency: ");
		        		 int answer3 = sc.nextInt();
		        		 reminder.setFrequency(answer3);
		        		 calendar.saveReminderToCalendar(reminder);
		        		 calendar.printReminderList(selection, reminder); 
		            }
		        }
		         else if (payment_frequency.equalsIgnoreCase("weekly")){
		        	 System.out.println("Do you want to be reminded every week? ");
		        	 String answer = sc.nextLine();
		        	 if(answer.equalsIgnoreCase("yes")) {
		        		 reminder.setFrequency(7);
		        		 calendar.saveReminderToCalendar(reminder);
		        		 calendar.printReminderList(selection, reminder); 
		        	 }
		        	 else {
		        		 System.out.println("Describe how ofter you want to be reminded: ");
		        		 String answer2 = sc.nextLine();
		        		 reminder.setPayment_frequency(answer2);
		        		 System.out.println("Insert the desired frequency: ");
		        		 int answer3 = sc.nextInt();
		        		 reminder.setFrequency(answer3);
		        		 calendar.saveReminderToCalendar(reminder);
		        		 calendar.printReminderList(selection, reminder); 
		        		
		            }
		       }
		         else if (payment_frequency.equalsIgnoreCase("monthly")){
		        	 System.out.println("Do you want to be reminded every month? ");
		        	 String answer = sc.nextLine();
		        	 if(answer.equalsIgnoreCase("yes")) {
		        		 reminder.setFrequency(30);
		        		 calendar.saveReminderToCalendar(reminder);
		        		 calendar.printReminderList(selection, reminder);
		        		 
		        	 }
		        	 else {
		        		 System.out.println("Describe how ofter you want to be reminded: ");
		        		 String answer2 = sc.nextLine();
		        		 reminder.setPayment_frequency(answer2);
		        		 System.out.println("Insert the desired frequency: ");
		        		 int answer3 = sc.nextInt();
		        		 reminder.setFrequency(answer3);
		        		 calendar.saveReminderToCalendar(reminder);
		        		 calendar.printReminderList(selection, reminder); 
		            }
		       }
		         else if (payment_frequency.equalsIgnoreCase("annual")){
		        	 System.out.println("Do you want to be reminded every year? ");
		        	 String answer = sc.nextLine();
		        	 if(answer.equalsIgnoreCase("yes")) {
		        		 reminder.setFrequency(365);
		        		 calendar.saveReminderToCalendar(reminder);
		        		 calendar.printReminderList(selection, reminder); 
		        	 }
		        	 else {
		        		 System.out.println("Describe how ofter you want to be reminded: ");
		        		 String answer2 = sc.nextLine();
		        		 reminder.setPayment_frequency(answer2);
		        		 System.out.println("Insert the desired frequency: ");
		        		 int answer3 = sc.nextInt();
		        		 reminder.setFrequency(answer3);
		        		 calendar.saveReminderToCalendar(reminder);
		        		 calendar.printReminderList(selection, reminder); 
		        		
		            }
		       }
		     }
	        }
	        else if(desicion.equalsIgnoreCase("delete")) {
	        	System.out.println("Please select the reminder you want to delete. Reminder id: " );
	        	int reminderid = sc.nextInt();
	        	sc.nextLine();
	        	calendar.deleteReminder(reminderid);
	        	
	        }
		 System.out.println("Do you want to continue using calendar?");
		 String option = sc.nextLine();
		 if (!option.equalsIgnoreCase("yes")) {
		        running = false; 
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

    public void deleteReminder(int reminderId) {
    	Reminder foundReminder = null;
        for (Reminder reminder : reminderList) {
            if (reminder.getReminder_id() == reminderId) {
                foundReminder = reminder;
                break;
            }
        }

        if (foundReminder != null) {
            reminderList.remove(foundReminder);
            System.out.println("Reminder with ID " + reminderId + " removed successfully.");
        } else {
            System.out.println("Reminder with ID " + reminderId + " not found.");
        }
    }
    

    public List<Reminder> getReminderList() {
        return reminderList;
    }

    public void setReminderList(List<Reminder> reminderList) {
        this.reminderList = reminderList;
    }
    
    
    
    public int getCalendar_id() {
		return calendar_id;
	}








	public void setCalendar_id(int calendar_id) {
		this.calendar_id = calendar_id;
	}





	public void printReminderList(String selection, Reminder reminder) {
		
        	System.out.println("------------------------");
            System.out.println("Calendar id: " + calendar_id);
        	System.out.println("Reminder id: " + reminder.getReminder_id());
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
    
    
