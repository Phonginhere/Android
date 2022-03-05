package com.example.imageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private static ImageView imgViewLofi;
    private static Button btnSwitchImage;

    private int currentImageIndex;
    int[] images = {R.mipmap.ic_launcher_lofi, R.mipmap.ic_launcher_lofi_with_glasses};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonClick();

    }
    public void buttonClick(){
     imgViewLofi = (ImageView) findViewById(R.id.imgViewLofi);
     btnSwitchImage = (Button) findViewById(R.id.btnSwitchImage);
     btnSwitchImage.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            currentImageIndex++; // tăng giá trị lên
            currentImageIndex = currentImageIndex % images.length; //chia tìm số dư = ảnh thứ bao nhiêu -> tạo sự lặp lại trong ảnh
            //imgViewLofi.setImageResource(images[currentImageIndex]); //hiện lên ảnh thứ bao nhiêu
             imgViewLofi.setImageResource(R.mipmap.ic_launcher_lofi); //hiện duy nhất 1 ảnh.
         }
     });
    }
}