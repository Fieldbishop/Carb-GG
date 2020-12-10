package com.example.carbgg;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Defines the Meal object and annotate it as a database object.
 * @author Jaakko Nahkala, Riku Immonen and Lassi Piispanen
 */

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

    /**
     *
     * @param mealName Name of the meal and the primary key for database row.
     * @param mealCarbs Meal carbohydrates.
     * @param mealDescription Not currently used. Can be left blank.
     */

    public Meal(@NonNull String mealName, @NonNull float mealCarbs, String mealDescription) {
        this.mealName = mealName;
        this.mealCarbs = mealCarbs;
        this.mealDescription = mealDescription;
        this.isFavourite = false;
    }

    /**
     * Gets mealName as is.
     * @return Returns mealName.
     */

    @NonNull
    public String getMealName() {
        return this.mealName;
    }

    /**
     * Gets mealCarbs as is.
     * @return Returns mealCarbs.
     */

    @NonNull
    public Float getMealCarbs() {
        return this.mealCarbs;
    }

    public String getMealDescription() {
        return this.mealDescription;
    }

    /**
     * Gets mealName as is and formats mealCarbs to string and strips decimals.
     * @return Returns mealName and formatted mealCarbs.
     */

    public String getMeal() {
        String mealCarbsD = String.format("%.0f", this.mealCarbs);

        return this.mealName + ", " + mealCarbsD + " g";
    }

    /**
     * Shows mealName as is.
     * @return Returns mealName.
     */

    @NonNull
    @Override
    public String toString() {
        return mealName;
    }
}