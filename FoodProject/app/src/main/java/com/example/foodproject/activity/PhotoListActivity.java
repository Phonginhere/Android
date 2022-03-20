//package com.example.foodproject.activity;
//
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.ListView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.foodproject.R;
//import com.example.foodproject.adapters.PhotoAdapter;
//import com.example.foodproject.models.Photo;
//import com.example.foodproject.services.IPhotoServiceResponse;
//import com.example.foodproject.services.PhotoService;
//
//import java.util.ArrayList;
//
//public class PhotoListActivity extends AppCompatActivity {
//    private ListView listViewPhotos;
//    private ArrayList<Photo> photos = new ArrayList<Photo>();
//    private PhotoService photoService = new PhotoService();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.photo_activity);
//        listViewPhotos = findViewById(R.id.listViewPhotos);
//        //Activity call "service"
//        photoService.getPhotos(new IPhotoServiceResponse() {
//            @Override
//            public void getPhotos(ArrayList<Photo> photos, String error) {
//
//                Log.d("ddd", "dsjmdjsd");
//                //objectA send DATA to objectB => su dung interface
//                //get photos HERE !
//                runOnUiThread(new Runnable() {
//                    public void run() {
//                        listViewPhotos.setAdapter(new PhotoAdapter(photos));
//                    }
//                });
//
//
//            }
//        });
//        //array of photos must be FILLED HERE !
//        //solve => photoService send finished DATA to PhotoListActivity
//
//        //Activity call service
//    }
//}
