package com.example.gridviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.gridviewtest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String[] bbiName = {"bbi","conganh","conganh2","cong anh 3",
                "bbi 2","babe","baby",
                "cong anh4","canh","kanh","coanh","onn"};
        int[] BbiImages = {R.drawable.bbi,R.drawable.me,
                R.drawable.me2,R.drawable.me3,
                R.drawable.me4,R.drawable.dtrai,
                R.drawable.me5,R.drawable.me6,
                R.drawable.me7,R.drawable.me8,
                R.drawable.ni,R.drawable.ni2};

        GridAdapter gridAdapter = new GridAdapter(MainActivity.this,bbiName,BbiImages);
        binding.gridView1.setAdapter(gridAdapter);

        binding.gridView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"you Clicked on"+bbiName[i],Toast.LENGTH_SHORT).show();
            }
        });
    }
}