package com.example.foodtrackerv1012;

public class User {
    private String name;
    private String surName;
    private int age;
    private double weight;
    private double height;
    private String allergens;
    private String unwantedIngredients;
    private String gender;
    private String dailyActivityLevel;
    private static final int userID = 1;

    public User(String name, String surName, int age, double weight, double height,
            String gender, String dailyActivityLevel, String allergens, String unwantedIngredients) {
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.allergens = allergens;
        this.unwantedIngredients = unwantedIngredients;
        this.gender = gender;
        this.dailyActivityLevel = dailyActivityLevel;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public String getAllergens() {
        return allergens;
    }

    public String getUnwantedIngredients() {
        return unwantedIngredients;
    }

    public String getGender() {
        return gender;
    }

    public String getDailyActivityLevel() {
        return dailyActivityLevel;
    }

 
    public static int getUserID() {
        return userID;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setAllergens(String allergens) {
        this.allergens = allergens;
    }

    public void setUnwantedIngredients(String unwantedIngredients) {
        this.unwantedIngredients = unwantedIngredients;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDailyActivityLevel(String dailyActivityLevel) {
        this.dailyActivityLevel = dailyActivityLevel;
    }

 

  

}
