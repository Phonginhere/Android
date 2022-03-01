package com.example.myapp;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapp.databinding.MainActivityBinding;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    private TextView labelName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //R = Resource
        setContentView(R.layout.main_activity);
        labelName = findViewById(R.id.labelName);
        labelName.setText("hahahahaha");
        Log.d("test", "kakaka");
    }

}