package com.example.sqllitetutorial.model;

public class Customer {

    private int id;
    private String name;
    private int Age;
    private boolean isActive;

    public Customer(int id, String name, int age, boolean isActive) {
        this.id = id;
        this.name = name;
        Age = age;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Age=" + Age +
                ", isActive=" + isActive +
                '}';
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

}
