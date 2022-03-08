package com.example.listapp.models;

import java.io.Serializable;

public class Person implements Serializable {
    private int personId;
    private String personName;
    private int age;
    private String occupation;

    public Person(int personId, String personName, int age, String occupation) {
        this.personId = personId;
        this.personName = personName;
        this.age = age;
        this.occupation = occupation;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
