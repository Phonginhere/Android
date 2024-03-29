package com.example.okhttpclient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.textclassifier.TextLinks;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private Button getBtn;
    private TextView result;
    private OkHttpClient client;
    public static final String urlGetPhotos = "https://jsonplaceholder.typicode.com/photos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (TextView) findViewById(R.id.result);
        getBtn = (Button) findViewById(R.id.getBtn);
        getBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWebService();
            }
        });
        //client = new OkHttpClient();
    }
    private void getWebService(){

        //final Request request = new Request.Builder().url(urlGetPhotos).build();
        int i =0;
        i++;
        client = new OkHttpClient();
        client.newCall(new Request.Builder().url(urlGetPhotos).build()).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        result.setText("Failure !");
                    }
                });
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            result.setText(response.body().string());
                        } catch (IOException ioe) {
                            result.setText("Error during get body");
                        }
                    }
                });
            }
        });
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {

//            }
//            @Override
//            public void onResponse(Call call, final Response response) {

//            }
//        });
    }

}