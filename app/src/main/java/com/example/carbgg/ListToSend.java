package com.example.carbgg;

import java.util.ArrayList;

public class ListToSend{
    private static ArrayList<Meal> meals;
    private static ListToSend ourInstance = new ListToSend();

    public static ListToSend getInstance() {
        if(ourInstance==null)
            ourInstance=new ListToSend();

        return ourInstance;
    }

    private ListToSend() {
        meals = new ArrayList<Meal>();
    }

    public void addMeal(String name, int carbs, String desc) {
        meals.add(new Meal(name, carbs, desc));
    }

    public ArrayList<Meal> getNames() {
        return meals;
    }

    public ArrayList<Meal> removeOne(int i){
        meals.remove(i);
        return meals;
    }

    public void eraseList() {
        ourInstance = null;
    }
}


