package phong.aprotrain.com.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import phong.aprotrain.com.R;

public class MainActivity extends AppCompatActivity {
    private ListView listViewNote;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        listViewNote = findViewById(R.id.listViewNote);

    }
}