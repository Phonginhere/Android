package phong.aprotrain.com.repositories;

import java.util.ArrayList;

import phong.aprotrain.com.model.Reminder;

public interface IReminderRepository {
    public void insertReminder(Reminder reminder);
    public Reminder updateReminder(Integer position, Reminder reminder);
    public void deleteReminder(String name);
    public ArrayList<Reminder> getAllReminders();

}
