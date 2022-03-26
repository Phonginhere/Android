package phong.aprotrain.com.activities;

import androidx.appcompat.app.AppCompatActivity;

import phong.aprotrain.com.repositories.IReminderRepository;
import phong.aprotrain.com.repositories.ReminderRepository;

public class BaseActivity extends AppCompatActivity {
    protected IReminderRepository reminderRepository = new ReminderRepository();
    public BaseActivity() {
        super();
    }
}
