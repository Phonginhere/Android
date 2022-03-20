package com.example.foodproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodproject.R;
import com.example.foodproject.models.Category;
import com.example.foodproject.view.CategoryItemView;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryItemView> {
    private ArrayList<Category> categories;
    private Context context;
    public CategoryAdapter(Context context, ArrayList<Category> categories) {
        this.context = context;
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategoryItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context)
                .inflate(R.layout.category_item, parent, false);
        //ACTION PRESS ON THIS VIEW
        CategoryItemView categoryItemView = new CategoryItemView(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Where is "position" ?  NO, let's use GETTER
                Category selectedCategory = categoryItemView.getCategory();
                Toast.makeText(CategoryAdapter.this.context
                        ,selectedCategory.getCategoryName(), Toast.LENGTH_LONG).show();
            }
        });
        return categoryItemView;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryItemView holder, int position) {
        Category selectedCategory = this.categories.get(position);
        holder.setCategory(selectedCategory);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
