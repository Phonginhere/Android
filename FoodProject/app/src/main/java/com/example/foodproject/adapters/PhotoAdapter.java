//package com.example.foodproject.adapters;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.TextView;
//
//import com.example.foodproject.R;
//import com.example.foodproject.models.Photo;
//
//import org.w3c.dom.Text;
//
//import java.util.ArrayList;
//
//public class PhotoAdapter extends BaseAdapter {
//    private ArrayList<Photo> photos;
//    public PhotoAdapter(ArrayList<Photo> photos){
//        this.photos = photos;
//    }
//    @Override
//    public int getCount() {
//        return this.photos.size();
//    }
//
//    @Override
//    public Object getItem(int i) {
//        return photos.get(i);
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return photos.get(i).getId();
//    }
//
//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.photo_item, viewGroup, false);
//        //Activity + Service
//        Photo photo = photos.get(i);
//        TextView textViewTitle = view.findViewById(R.id.textViewTitle);
//        textViewTitle.setText(photo.getTitle());
//        return view;
//    }
//}
