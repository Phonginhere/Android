package com.example.buoi8service.services;


import okhttp3.OkHttpClient;
import okhttp3.Request;

public class PhotoService {
    private OkHttpClient okHttpClient = new OkHttpClient();
    public static final String urlGetPhoto = "https://jsonplaceholder.typicode.com/photos";
    //callback function: goi lai
    public void getAllPhotos(){
        Request request = new Request.Builder().url(urlGetPhoto).build();

    }
}
