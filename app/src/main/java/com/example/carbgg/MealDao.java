package com.example.carbgg;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

/**
 * Database access points.
 * @author Jaakko Nahkala, Riku Immonen and Lassi Piispanen
 */

@Dao
public interface MealDao {

    /**
     * Adds new Meal to the database. Ignores Meals that already exist in the database.
     * @param meal Meal object constructor.
     */

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Meal meal);

    /**
     * Empties the table. Used in MealRoomDatabase.java on new database creation.
     */

    @Query("DELETE FROM Meal")
    void deleteAll();

    @Query("SELECT * FROM Meal ORDER BY mealName ASC")
    LiveData<List<Meal>> getAlphabetizedMeals();

    /**
     * Deletes row if mealName matches the given string.
     * @param name Meal's primary key.
     */

    @Query("DELETE FROM Meal WHERE mealName = :name")
    void deleteMeal(String name);
}