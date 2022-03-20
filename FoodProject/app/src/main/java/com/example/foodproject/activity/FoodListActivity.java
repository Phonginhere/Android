package com.example.foodproject.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodproject.R;
import com.example.foodproject.adapters.CategoryAdapter;
import com.example.foodproject.adapters.FoodAdapter;
import com.example.foodproject.database.DatabaseHelper;
import com.example.foodproject.models.Category;
import com.example.foodproject.models.Food;

import java.util.ArrayList;

public class FoodListActivity extends AppCompatActivity {
    //recycle view
    private RecyclerView recycleViewFoods;
    private RecyclerView recycleViewCategory;
    //adapter
    private FoodAdapter foodAdapter;
    private CategoryAdapter categoryAdapter;
    //array list
    private ArrayList<Food> foods = new ArrayList();
    private ArrayList<Category> categories = new ArrayList();
    //Horizontal or Vertical ?
    private RecyclerView.LayoutManager layoutManager;
    //db
    DatabaseHelper databaseHelper;

    private void getCategory() {
        //call api later
        //mock
        categories.add(new Category(
               "Most Favorites",
                20)
        );
        categories.add(new Category(
                "Top of the bill",
                20)
        );
        categories.add(new Category(
                "Asian",
                20)
        );

    }

//    private void getFoods() {
//        //call api later
//        //mock
//        foods.add(new Food(
//                1,
//                "sudhy",
//                "this is Sushy Japana",
//                123.0,
//                "https://upload.wikimedia.org/wikipedia/commons/2/2a/Sasazushi.jpg")
//        );
//        foods.add(new Food(
//                2,
//                "sudhy11",
//                "this is Sushy Japana11",
//                234.0,
//                "https://upload.wikimedia.org/wikipedia/commons/2/2a/Sasazushi.jpg")
//        );
//        foods.add(new Food(
//                3,
//                "sudhy33",
//                "this is Sushy Japana33",
//                44.0,
//                "https://upload.wikimedia.org/wikipedia/commons/2/2a/Sasazushi.jpg")
//        );
//        foods.add(new Food(
//                4,
//                "sudhy44",
//                "this is Sushy Japana",
//                666.0,
//                "https://upload.wikimedia.org/wikipedia/commons/2/2a/Sasazushi.jpg")
//        );
//        foods.add(new Food(
//                5,
//                "sudhy33",
//                "this is Sushy Japana33",
//                44.0,
//                "https://upload.wikimedia.org/wikipedia/commons/2/2a/Sasazushi.jpg")
//        );
//        foods.add(new Food(
//                6,
//                "sudhy44",
//                "this is Sushy Japana",
//                666.0,
//                "https://upload.wikimedia.org/wikipedia/commons/2/2a/Sasazushi.jpg")
//        );
//        foods.add(new Food(
//                7,
//                "sudhy33",
//                "this is Sushy Japana33",
//                44.0,
//                "https://upload.wikimedia.org/wikipedia/commons/2/2a/Sasazushi.jpg")
//        );
//        foods.add(new Food(
//                8,
//                "sudhy44",
//                "this is Sushy Japana",
//                666.0,
//                "https://upload.wikimedia.org/wikipedia/commons/2/2a/Sasazushi.jpg")
//        );
//        foods.add(new Food(
//                9,
//                "sudhy33",
//                "this is Sushy Japana33",
//                44.0,
//                "https://upload.wikimedia.org/wikipedia/commons/2/2a/Sasazushi.jpg")
//        );
//        foods.add(new Food(
//                10,
//                "sudhy44",
//                "this is Sushy Japana",
//                666.0,
//                "https://upload.wikimedia.org/wikipedia/commons/2/2a/Sasazushi.jpg")
//        );
//
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_activity);

        recycleViewFoods = findViewById(R.id.recycleViewFoods);
        databaseHelper = new DatabaseHelper(this);
//        for(int i = 0; i < 5; i++){
//            databaseHelper.addOne(new Food(1, "duck"+i, "...", 123.000, "https://upload.wikimedia.org/wikipedia/commons/2/2a/Sasazushi.jpg"));
//        }
//        getFoods();
        foods = databaseHelper.getEveryOne();

        foodAdapter = new FoodAdapter(this, foods);
        recycleViewFoods.setAdapter(foodAdapter);
        //Horizontal or Vertical ? vertical
        layoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false);
        recycleViewFoods.setLayoutManager(layoutManager);

        //Horizontal Category
        recycleViewCategory = findViewById(R.id.recycleViewCategory);
        getCategory();
        categoryAdapter = new CategoryAdapter(this, categories);
        recycleViewCategory.setAdapter(categoryAdapter);
        //Horizontal or Vertical ? Horizontal
        layoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.HORIZONTAL, false);
        recycleViewCategory.setLayoutManager(layoutManager);


    }
}
