package com.example.carbgg;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MealDao {
    // allowing the insert of the same meal multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Meal meal);

    @Query("DELETE FROM Meal")
    void deleteAll();

    @Query("SELECT * FROM Meal ORDER BY mealName ASC")
    LiveData<List<Meal>> getAlphabetizedMeals();
}