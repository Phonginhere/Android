package com.example.foodproject.models;

public class Category {
    private String CategoryName;
    private int CategoryQuantity;

    public Category(String categoryName, int categoryQuantity) {
        CategoryName = categoryName;
        CategoryQuantity = categoryQuantity;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public int getCategoryQuantity() {
        return CategoryQuantity;
    }

    public void setCategoryQuantity(int categoryQuantity) {
        CategoryQuantity = categoryQuantity;
    }
}
