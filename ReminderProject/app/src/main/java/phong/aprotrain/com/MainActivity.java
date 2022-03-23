package phong.aprotrain.com;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

import phong.aprotrain.com.adapter.CustomAdapter;
import phong.aprotrain.com.model.Reminder;

public class MainActivity extends AppCompatActivity {

    private ListView listViewReminder;
    private static ArrayList<Reminder> reminders = new ArrayList<>();
    private CustomAdapter customAdapter;
    protected static String noidung;
    protected static boolean quantrong;
    protected static String positionToEdit;

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
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));

        listViewReminder = findViewById(R.id.listViewReminder);
//        getReminder();
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

    public static void onCreateReminder(String textName,boolean status){
        reminders.add(new Reminder(textName, status));
    }

    public static void onRemoveReminder(int position){
        reminders.remove(position);
    }

    public static void onEditViewReminder(int position){
        Reminder sReminder = reminders.get(position);
        noidung = sReminder.getNoidung();
        quantrong = sReminder.isQuantrong();
        positionToEdit = String.valueOf(position);
    }
    public static void onEditPostReminder(String position, String textName,boolean status){
        reminders.set(Integer.parseInt(position), new Reminder(textName, status));
        reminders.remove(position);
    }
}