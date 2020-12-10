package com.example.carbgg;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Defines the Meal object and annotate it as a database object.
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
     * Constructs a Meal object.
     *
     * @param mealName Meal name, used on database as a key for the row.
     * @param mealCarbs Amount of carbohydrates in the meal.
     * @param mealDescription Extra information about the meal. Currently unused and is recommended
     *                        to be left empty.
     */

    public Meal(@NonNull String mealName, @NonNull float mealCarbs, String mealDescription) {
        this.mealName = mealName;
        this.mealCarbs = mealCarbs;
        this.mealDescription = mealDescription;
        this.isFavourite = false;
    }

    /**
     * Gets mealName as is.
     * @return Gives mealName.
     */

    @NonNull
    public String getMealName() {
        return this.mealName;
    }

    /**
     * Gets mealCarbs as is.
     * @return Gives mealCarbs.
     */

    @NonNull
    public Float getMealCarbs() {
        return this.mealCarbs;
    }

    /**
     * Gets mealName as it is and formats mealCarbs to String type and omits decimals.
     *
     * @return Returns mealName and formatted mealCarbs.
     */

    public String getMeal() {
        String mealCarbsD = String.format("%.0f", this.mealCarbs);

        return this.mealName + ", " + mealCarbsD + " g";
    }

    /**
     * Gets mealName as is.
     * @return Gives mealName.
     */

    @NonNull
    @Override
    public String toString() {
        return mealName;
    }
}