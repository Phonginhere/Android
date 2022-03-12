package com.example.buoi8service;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.buoi8service.adapters.PhotoAdapter;
import com.example.buoi8service.models.Photo;
import com.example.buoi8service.services.IPhotosResponse;
import com.example.buoi8service.services.PhotoService;

import java.util.ArrayList;

public class PhotoListActivity extends AppCompatActivity {
    private ListView listViewPhotos;
    private ArrayList<Photo> photos = new ArrayList<>();
    private PhotoService photoService = new PhotoService();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_list_activity);
        listViewPhotos = (ListView) findViewById(R.id.listViewPhotos);
        photoService.getAllPhotos(new IPhotosResponse() {
            @Override
            public void getPhotosResponse(ArrayList<Photo> photos, String error) {

            }

            @Override
            public void sayHello(String content) {
                Log.d("aa", "haha");
                //thay vi truyen content, truyen photo sang activity
                listViewPhotos.setAdapter(new PhotoAdapter(photos));
            }
        });
        listViewPhotos.setAdapter(new PhotoAdapter(photos)); //cau noi giua data va giao dien tren listview


//        photos.add(new Photo(1, 1, "hahah", "https://via.placeholder.com/600/92c952", "https://via.placeholder.com/600/92c952"));
//        photos.add(new Photo(1, 2, ""));

    }
}