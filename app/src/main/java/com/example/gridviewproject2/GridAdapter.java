package com.example.gridviewproject2;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {
    Context context;
    String[] flowerName;
    int[] image;


    public GridAdapter(Context context, String[] flowerName, int[] image) {
        this.context = context;
        this.flowerName = flowerName;
        this.image = image;
    }

    @Override
    public int getCount() {
        return flowerName.length;
    }

    @Override
    public Object getItem(int i) {
        return flowerName[i];
    }

    @Override
    public long getItemId(int i) {
        return flowerName[i].hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = convertView == null ? inflater.inflate(R.layout.grid_item, null) : convertView;         ImageView imageView = convertView.findViewById(R.id.gridImage);
        TextView textView = convertView.findViewById(R.id.itemName);
        imageView.setImageResource(image[position]);
        textView.setText(flowerName[position]);

        return convertView;
    }
}
