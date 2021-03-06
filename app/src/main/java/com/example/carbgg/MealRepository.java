package com.example.carbgg;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * Creates LiveDataList from database entries
 * @author Jaakko Nahkala, Riku Immonen and Lassi Piispanen
 */

class MealRepository {
    private final LiveData<List<Meal>> AllMeals;

    MealRepository(Application application) {
        MealRoomDatabase db = MealRoomDatabase.getDatabase(application);
        MealDao mMealDao = db.mealDao();
        AllMeals = mMealDao.getAlphabetizedMeals();
    }

    LiveData<List<Meal>> getAllMeals() {
        return AllMeals;
    }
}