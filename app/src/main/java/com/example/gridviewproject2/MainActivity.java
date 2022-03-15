package com.example.gridviewproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.gridviewproject2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    //private ActivityMainBinding binding;
    private GridAdapter gridAdapter;
    private GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gridview);
        String[] flowerName = {"thorTiger", "Tiger", "Tigon", "wolf", "wolf2", "wolf3"};
        int[] flowerImages = {R.drawable.thortiger, R.drawable.tiger, R.drawable.tigon, R.drawable.wolf, R.drawable.wolf2, R.drawable.wolf3};

        gridAdapter = new GridAdapter(MainActivity.this, flowerName, flowerImages);
        gridView.setAdapter(gridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "You clicked on"+flowerName[i], Toast.LENGTH_SHORT).show();
            }
        });
    }
}