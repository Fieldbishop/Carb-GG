package com.example.carbgg;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

class MealRepository {

    private MealDao mMealDao;
    private LiveData<List<Meal>> AllMeals;

    MealRepository(Application application) {
        MealRoomDatabase db = MealRoomDatabase.getDatabase(application);
        mMealDao = db.mealDao();
        AllMeals = mMealDao.getAlphabetizedMeals();
    }

    LiveData<List<Meal>> getAllMeals() {
        return AllMeals;
    }

    public void insert(Meal meal) {
        MealRoomDatabase.databaseWriteExecutor.execute(() -> {
            mMealDao.insert(meal);
        });
    }
/*
    public String getSingleMeal(String singleMealName){
        return mMealDao.getSingleMeal();
    }

 */
}