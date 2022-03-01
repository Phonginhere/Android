package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PlacesActivity extends AppCompatActivity {
    private TextView txtInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);
        txtInfo = (TextView) findViewById(R.id.txtInfo);
        Bundle extras = getIntent().getExtras(); //tra doi tuong tin truyen tu ben kia sang
        if(extras != null){
            String email = extras.getString("email");
            txtInfo.setText("Your email: "+email);
        }
    }
}