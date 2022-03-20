//package com.example.foodproject.services;
//
//import android.util.Log;
//
//import androidx.annotation.NonNull;
//
//import com.example.foodproject.models.Photo;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//import okhttp3.Call;
//import okhttp3.Callback;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;
//
//public class PhotoService {
//    public static final String urlPhotos = "https://jsonplaceholder.typicode.com/photos";
//    private OkHttpClient okHttpClient = new OkHttpClient();
//    public void getPhotos(IPhotoServiceResponse photoServiceResponse){
//        okHttpClient.newCall(new Request.Builder().url(urlPhotos).build()).enqueue(new Callback() {
//            @Override
//            public void onFailure(@NonNull Call call, @NonNull IOException e) {
//                //link die, internet failed 404, internet permission
//                Log.d("failed", "failed");
//            }
//
//            @Override
//            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
//                ArrayList<Photo> photos = new ArrayList<>();
//                try{
//                    Log.d("success", "success");
//                    String jsonString = response.body().string();
//                    JSONArray responseArray = new JSONArray(jsonString);
//                    for(int i = 0; i < responseArray.length(); i++){
//                        JSONObject jsonObject = responseArray.getJSONObject(i);
//                        Photo photo = Photo.getFromJsonObject(jsonObject);
//                        photos.add(photo);
//                        Log.d("aaa", "aaa");
//                    }
//                    photoServiceResponse.getPhotos(photos, "");
//                } catch (Exception e) {
//                    photoServiceResponse.getPhotos(photos, e.toString());
//                }
//            }
//        });
//        Log.d("ddd", "do other...");
//    }
//}
