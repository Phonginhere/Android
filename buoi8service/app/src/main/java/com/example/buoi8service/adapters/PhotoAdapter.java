package com.example.buoi8service.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.buoi8service.R;
import com.example.buoi8service.models.Photo;

import java.util.ArrayList;

public class PhotoAdapter extends BaseAdapter {
    ArrayList<Photo> photos;
    public PhotoAdapter(ArrayList<Photo> photos){
        this.photos = photos;
    }
    @Override
    public int getCount() {
        return this.photos.size();
    }

    @Override
    public Object getItem(int position) {
        return photos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return photos.get(position).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.photo_list, viewGroup, false);

        Photo photo = photos.get(i);
        TextView textViewTitle = view.findViewById(R.id.textViewTitle);
        textViewTitle.setText(photo.getTitle());
        return view;
    }
}
