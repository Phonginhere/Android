package com.example.foodproject.view;

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

    public void setCategory(Category category) {
        this.category = category;
        textViewCategory.setText(category.getCategoryName());
        txtNumber.setText(category.getCategoryQuantity());
    }

    public Category getCategory() {
        return category;
    }

    public CategoryItemView(@NonNull View itemView) {
        super(itemView);
        textViewCategory = itemView.findViewById(R.id.textViewCategory);
        txtNumber = itemView.findViewById(R.id.txtNumber);
    }
}
