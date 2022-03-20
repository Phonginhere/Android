package com.example.foodproject.view;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodproject.R;
import com.example.foodproject.models.Food;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class FoodItemView extends RecyclerView.ViewHolder {
    private TextView textViewFoodName;
    private TextView textViewDescription;
    private TextView textViewPrice;
    private ImageView imageViewFood;
    private Food food;

    public void setFood(Food food) {
        this.food = food;
        textViewFoodName.setText(food.getFoodName());
        textViewDescription.setText(food.getDescription());
        textViewPrice.setText(String.format("$ %f", food.getPrice()));
        //image view food -> using Picasso
        Picasso.get()
                .load(food.getUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageViewFood);
    }

    public Food getFood() {
        return food;
    }

    public FoodItemView(@NonNull View itemView) {
        super(itemView);
        textViewFoodName = itemView.findViewById(R.id.textViewFoodName);
        textViewDescription = itemView.findViewById(R.id.textViewDescription);
        textViewPrice = itemView.findViewById(R.id.textViewPrice);
        imageViewFood =(ImageView) itemView.findViewById(R.id.imageViewFood);
    }
}
