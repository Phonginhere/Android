package com.example.buoi8service.services;


import android.util.Log;

import androidx.annotation.NonNull;

import com.example.buoi8service.models.Photo;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PhotoService {
    private OkHttpClient okHttpClient = new OkHttpClient();
    public static final String urlGetPhoto = "https://jsonplaceholder.typicode.com/photos";
    //callback function: goi lai
    public void getAllPhotos(IPhotosResponse photosResponse){
        okHttpClient.newCall(new Request.Builder().url(urlGetPhoto).build()).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.d("failed", "failed");
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                Log.d("success", "success");

                ArrayList<Photo> fakePhotos = new ArrayList<>();
                fakePhotos.add(new Photo(1,1, "xx", "yy", "zz"));
                photosResponse.getPhotosResponse(fakePhotos);
            }
        });
        Log.d("ddd", "do other");
    }
}
