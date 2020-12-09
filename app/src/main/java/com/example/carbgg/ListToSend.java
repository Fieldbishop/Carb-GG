package com.example.carbgg;

import java.util.ArrayList;

/**
 * Singleton arraylist for sending data from meal activity to the calculator activity
 */
public class ListToSend{
    private static ArrayList<Meal> meals;
    private static ListToSend ourInstance = new ListToSend();

    /**
     *
     * @return instance of the arraylist
     */
    public static ListToSend getInstance() {
        if(ourInstance==null)
            ourInstance=new ListToSend();

        return ourInstance;
    }

    /**
     * constructor
     */
    private ListToSend() {
        meals = new ArrayList<Meal>();
    }

    /**
     * Adds a new meal to the arraylist
     * @param name name corresponding to the meal
     * @param carbs amount of carbohydrates in the meal
     * @param desc description for the meal (not used yet)
     */
    public void addMeal(String name, int carbs, String desc) {
        meals.add(new Meal(name, carbs, desc));
    }

    /**
     * @return arraylist
     */
    public ArrayList<Meal> getNames() {
        return meals;
    }

    /**
     * removes an object corresponding to the position "i" provided from the list
     * @param i index of the object to be removed
     * @return the list with the object removed
     */
    public ArrayList<Meal> removeOne(int i){
        meals.remove(i);
        return meals;
    }

    /**
     * Clears the list from objects
     */
    public void eraseList() {
        ourInstance = null;
    }
}


