package com.example.myappbuoi3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myappbuoi3.model.Product;

public class ProgrammingActivity extends AppCompatActivity {
    private RadioButton rbJava;
    private RadioButton rbCsharp;
    private Button btnSubmit;
    private TextView textViewCsharp;
    private TextView textViewJava;
    private int x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Product a = new Product(1, "iphone", 100.2);
        //Toast.makeText(this,String.format("product's detail:  %s", a.toString()), Toast.LENGTH_LONG).show();
        setContentView(R.layout.programming_activity);
        rbJava =(RadioButton)findViewById(R.id.rbJava);
        rbCsharp =(RadioButton)findViewById(R.id.rbCsharp);
        btnSubmit =(Button) findViewById(R.id.btnSubmit);
        textViewCsharp =(TextView) findViewById(R.id.textViewCsharp);
        textViewJava =(TextView) findViewById(R.id.textViewJava);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean rbJavaChecked = rbJava.isChecked();
                boolean rbCsharpChecked = rbCsharp.isChecked();
                if(rbCsharpChecked){
                    Toast.makeText(getApplicationContext(), "You choose: " +textViewCsharp.getText(), Toast.LENGTH_LONG).show();
                }
                if(rbJavaChecked){
                    Toast.makeText(getApplication(), "You choose: " +textViewJava.getText(), Toast.LENGTH_LONG).show();
                }
//                Toast.makeText(getApplicationContext(), "phong dep trai", Toast.LENGTH_LONG).show();
            }
        });
    }
}