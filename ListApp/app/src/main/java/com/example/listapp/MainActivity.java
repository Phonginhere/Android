package com.example.listapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.listapp.activity.PersonListActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnNavigateLogin;
    private Button btnNavigatePlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNavigateLogin = findViewById(R.id.btnNavigateLogin);
        btnNavigatePlist = findViewById(R.id.btnNavigatePlist);

        btnNavigatePlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, PersonListActivity.class);
                startActivity(intent);
            }
        });

    }
}