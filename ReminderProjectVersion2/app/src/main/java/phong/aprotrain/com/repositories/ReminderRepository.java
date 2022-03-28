package phong.aprotrain.com.repositories;

import java.io.Serializable;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import phong.aprotrain.com.model.Reminder;

public class ReminderRepository implements IReminderRepository, Serializable {
    private ArrayList<Reminder> reminders =new ArrayList<>();
    public ReminderRepository() {
        final LocalDateTime localDateTime;
//        reminders.add(new Reminder("Hoc Android", false, ));
    }

    public void setReminders (ArrayList<Reminder> reminders){this.reminders = reminders;}

    @Override
    public void insertReminder(Reminder reminder) {
        if(reminder.getNoidung().trim().length() > 0){
            reminders.add(reminder);
        }
    }

    @Override
    public Reminder updateReminder(Integer position, Reminder reminder) {
        try{
            if(position < 0 || position >= reminders.size()){
                return null;
            }
            Reminder foundReminder = reminders.get(position);
            if(foundReminder != null){
                foundReminder.setNoidung(reminder.getNoidung());
                foundReminder.setQuantrong(reminder.isQuantrong());
                foundReminder.setNgaytao(reminder.getNgaytao());
            }
            return foundReminder;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public void deleteReminder(String noidung) {
        reminders.removeIf(eachReminder -> eachReminder.getNoidung().equals(noidung));
    }


    @Override
    public ArrayList<Reminder> getAllReminders() {
        return reminders;
    }
}
