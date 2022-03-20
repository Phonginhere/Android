package com.example.foodproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodproject.R;
import com.example.foodproject.models.Food;
import com.example.foodproject.view.FoodItemView;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodItemView>{
    private ArrayList<Food> foods;
    private Context context;
    public FoodAdapter(Context context, ArrayList<Food> foods){
        this.context = context;
        this.foods = foods;
    }

    @NonNull
    @Override
    public FoodItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context)
                .inflate(R.layout.food_item, parent, false);
        //action press on this view
        FoodItemView foodItemView = new FoodItemView(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Food selectedFood = foodItemView.getFood();
                Toast.makeText(FoodAdapter.this.context
                        , selectedFood.getFoodName(), Toast.LENGTH_LONG).show();
            }
        });

        return foodItemView;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodItemView foodItemView, int position) {
        Food selectedFood = this.foods.get(position);
        foodItemView.setFood(selectedFood);
    }

    @Override
    public int getItemCount() {
        return this.foods.size();
    }
}
