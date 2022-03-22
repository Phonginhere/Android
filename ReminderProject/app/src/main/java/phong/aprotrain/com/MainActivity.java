package phong.aprotrain.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import phong.aprotrain.com.adapter.CustomAdapter;
import phong.aprotrain.com.model.Reminder;

public class MainActivity extends AppCompatActivity {
    private ListView listViewReminder;
    private ArrayList<Reminder> reminders = new ArrayList<>();
    private CustomAdapter customAdapter;

    //menu

    public void getReminder(){
        reminders.add(new Reminder(
                "Buy Cream",
                true)
        );
        reminders.add(new Reminder(
                "Buy Cream",
                false)
        );
        reminders.add(new Reminder(
                "Buy sth",
                true)
        );
        reminders.add(new Reminder(
                "Buy sth",
                true)
        );
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewReminder = findViewById(R.id.listViewReminder);
        getReminder();
        customAdapter = new CustomAdapter(this, reminders);
        listViewReminder.setAdapter(customAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.newReminder:
                Intent createIntent = new Intent(MainActivity.this, CreateActivity.class);
                MainActivity.this.startActivity(createIntent);
            case R.id.exit:System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }
}