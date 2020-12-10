package com.example.carbgg;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * Manages data for recyclerview
 * @author Jaakko Nahkala, Riku Immonen and Lassi Piispanen
 */
public class MealViewModel extends AndroidViewModel {

    private final LiveData<List<Meal>> allMeals;

    public MealViewModel(Application application) {
        super(application);
        MealRepository mealRepository = new MealRepository(application);
        allMeals = mealRepository.getAllMeals();
    }

    LiveData<List<Meal>> getAllMeals() {
        return allMeals;
    }
}