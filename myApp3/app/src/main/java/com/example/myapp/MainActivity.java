package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Press oke", Toast.LENGTH_LONG).show();
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Your alert")
                        .setMessage("Your message")
                        .setCancelable(false)
                        .setPositiveButton("ok", (DialogInterface dialog, int which) ->{

                        }).show();
            }
        });
    }
}