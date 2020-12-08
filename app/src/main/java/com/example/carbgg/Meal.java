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
    private Float mealCarbs;

    @ColumnInfo(name = "mealDescription")
    private String mealDescription;

    @ColumnInfo(name = "isFavourite")
    private boolean isFavourite;

    public Meal(@NonNull String mealName, @NonNull float mealCarbs, String mealDescription) {
        this.mealName = mealName;
        this.mealCarbs = mealCarbs;
        this.mealDescription = mealDescription;
        this.isFavourite = false;
    }

    public void setIsFavourite (boolean isFavourite) {
        this.isFavourite = isFavourite;
    }

    public String getMealName() {
        return this.mealName;
    }

    public Float getMealCarbs() {
        return this.mealCarbs;
    }

    public String getMealDescription() {
        return this.mealDescription;
    }

    public boolean getIsFavourite() {
        return this.isFavourite;
    }

    public String getMeal() {
        String mealCarbsD = String.format("%.0f", this.mealCarbs);

        return this.mealName + ", " + mealCarbsD + " g";
    }
    @Override
    public String toString() {
        return mealName;
    }
}