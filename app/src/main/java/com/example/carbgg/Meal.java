package com.example.carbgg;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Meal")
public class Meal {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "mealName")
    private String mealName;

    @NonNull
    @ColumnInfo(name = "mealCarbs")
    private float mealCarbs;

    @ColumnInfo(name = "mealDescription")
    private String mealDescription;

    /*
    // mahd. lisattavat

    private boolean isFavourite;
    private int mealCarbsPer;
    private int mealSize;
    */

    public Meal(@NonNull String mealName, @NonNull float mealCarbs, String mealDescription) {
        this.mealName = mealName;
        this.mealCarbs = mealCarbs;
        this.mealDescription = mealDescription;
    }

    public String getMealName() {
        return this.mealName;
    }

    public float getMealCarbs() {
        return this.mealCarbs;
    }

    public String getMealDescription() {
        return this.mealDescription;
    }

    public String getMeal() {
        String mealCarbsD = String.format("%.0f", this.mealCarbs);

        return this.mealName + ", " + mealCarbsD + " g";
    }
}