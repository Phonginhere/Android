package com.example.foodproject.view;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodproject.R;
import com.example.foodproject.models.Category;
import com.example.foodproject.models.Food;
import com.squareup.picasso.Picasso;

public class CategoryItemView extends RecyclerView.ViewHolder {
    private TextView textViewCategory;
    private TextView txtNumber;

    private Category category;
    private int position;
    private View itemView;

    public void setCategory(Category category,int position) {
        this.category = category;
        this.position = position;
        textViewCategory.setText(category.getCategoryName());
        txtNumber.setText(String.valueOf(category.getCategoryQuantity()));
        itemView.setBackgroundColor(position %2 == 0 ?
                Color.rgb(255, 0,0): Color.rgb(0, 255,0));
    }

    public Category getCategory() {
        return category;
    }

    public CategoryItemView(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
        textViewCategory = itemView.findViewById(R.id.textViewCategory);
        txtNumber = itemView.findViewById(R.id.txtNumber);

    }
}
