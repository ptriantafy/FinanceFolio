package com.financefolio.calendar;

import java.util.ArrayList;
import java.util.List;

public class Calendar {
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
