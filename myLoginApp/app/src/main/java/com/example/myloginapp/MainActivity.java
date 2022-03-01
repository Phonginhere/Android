package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Locale;

public class MainActivity extends Activity {
    public static final String emailPattern ="^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    private EditText txtEmail;
    private EditText txtPassword;
    private Button btnLogin;
    private TextView txtValidate;

    private Boolean isValidEmail = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //anh xa giua file main_activity.xml vs class nay
        txtEmail = (EditText) findViewById(R.id.txtEmail); //anh xa thuoc tinh txtEmail vs txtEmail tren file .xml
        txtPassword = (EditText) findViewById(R.id.txtPassword); //anh xa thuoc tinh txtPassword vs txtPassword tren file .xml
        txtValidate = (TextView) findViewById(R.id.txtValidate);
        btnLogin = (Button) findViewById(R.id.btnLogin); //anh xa thuoc tinh btnLogin vs btnLogin tren file .xml
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //thuc thi click trong interface, on click la ban se lam gi do
                    //show small alert
                if(!isValidEmail){
                    Toast.makeText(getApplicationContext(), "Validate email failed", Toast.LENGTH_LONG).show();
                    return;
                }
                String email = txtEmail.getText().toString().trim(); //loai bo 2 khoang trong o dau va cuoi
                Toast.makeText(getApplicationContext(), "Well done", Toast.LENGTH_LONG).show();
                //begin do sth to navigate activy
                Intent intent = new Intent(MainActivity.this, PlacesActivity.class);
                intent.putExtra("email", txtEmail.getText().toString().trim());
                startActivity(intent);
                //end do sth to navigate activy
            }
        }); //set su kien
        txtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    //validate
                txtValidate.setText("");
                String email = txtEmail.getText().toString().trim();
                isValidEmail = (email.matches(emailPattern) && charSequence.length() > 0); //charSequence: la tung cai chu minh go vao do, co go vao thi moi co validate
                if(!isValidEmail){
                    txtValidate.setTextColor(Color.rgb(255, 0, 0));
                    txtValidate.setText("Invalid email Address");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}