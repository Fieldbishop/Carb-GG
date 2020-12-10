package com.example.carbgg;

import java.util.ArrayList;

/**
 * Singleton arraylist for storing objects "DataPointToSave"
 * @author Jaakko Nahkala, Riku Immonen and Lassi Piispanen
 */
public class SingletonClassHistory {
    private static ArrayList<DataPointToSave> dataPoints;
    private static SingletonClassHistory ourInstance = new SingletonClassHistory();

    /**
     * getInstance
     * @return instance
     */
    public static SingletonClassHistory getInstance() {
        if(ourInstance==null)
            ourInstance=new SingletonClassHistory();

        return ourInstance;
    }

    /**
     * Creates a new Arraylist if one is not found
     */
    private SingletonClassHistory() {
        dataPoints = new ArrayList<DataPointToSave>();
    }

    /**
     * adds an object DataPointToSave on to the list
     * @param date date of calculation
     * @param carbs total carbs calculated
     */
    public void addNew(String date, float carbs) {
        dataPoints.add(new DataPointToSave(date, carbs));
    }

    /**
     *
     * @return arraylist
     */
    public ArrayList<DataPointToSave> getAll() {
        return dataPoints;
    }

    /**
     * removes an object in arraylist with position "i" provided
     * @param i the index of the item we want to remove
     * @return arraylist with the object removed
     */
    public ArrayList<DataPointToSave> removeOne(int i){
        dataPoints.remove(i);
        return dataPoints;
    }

    /**
     * Clears list (ununsed)
     */
    public void eraseList() {
        ourInstance = null;
    }
}
