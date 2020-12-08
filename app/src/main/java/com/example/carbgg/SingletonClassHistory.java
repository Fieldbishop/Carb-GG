package com.example.carbgg;

import java.util.ArrayList;

public class SingletonClassHistory {
    private static ArrayList<DataPointToSave> dataPoints;
    private static SingletonClassHistory ourInstance = new SingletonClassHistory();

    public static SingletonClassHistory getInstance() {
        if(ourInstance==null)
            ourInstance=new SingletonClassHistory();

        return ourInstance;
    }

    private SingletonClassHistory() {
        dataPoints = new ArrayList<DataPointToSave>();
    }

    public void addNew(String date, float carbs) {
        dataPoints.add(new DataPointToSave(date, carbs));
    }

    public ArrayList<DataPointToSave> getAll() {
        return dataPoints;
    }

    public ArrayList<DataPointToSave> removeOne(int i){
        dataPoints.remove(i);
        return dataPoints;
    }

    public void eraseList() {
        ourInstance = null;
    }
}
