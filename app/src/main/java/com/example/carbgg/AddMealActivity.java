package com.example.carbgg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class AddMealActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meal);

        EditText editTextMealName = findViewById(R.id.editTextMealName);
        EditText editTextMealCarbs = findViewById(R.id.editTextMealCarbs);
        Button buttonSave = findViewById(R.id.buttonSave);
        Button buttonAllMeals = findViewById(R.id.buttonAllMeals);

        MealRoomDatabase db = MealRoomDatabase.getDatabase(this.getApplicationContext());
        MealDao mMealDao = db.mealDao();

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(editTextMealName.getText()) || TextUtils.isEmpty(editTextMealCarbs.getText())) {
                    Snackbar error = Snackbar.make(AddMealActivity.this.findViewById(R.id.activity_add_meal), R.string.empty_not_saved, Snackbar.LENGTH_LONG);
                    error.show();
                } else {
                    String mealName = editTextMealName.getText().toString();
                    float mealCarbs = Float.parseFloat(editTextMealCarbs.getText().toString());

                    Meal meal = new Meal(mealName, mealCarbs, "");

                    MealRoomDatabase.databaseWriteExecutor.execute(() -> {
                        mMealDao.insert(meal);
                    });

                    Snackbar success = Snackbar.make(AddMealActivity.this.findViewById(R.id.activity_add_meal), R.string.meal_saved, Snackbar.LENGTH_LONG);
                    success.show();
                }

                AddMealActivity.this.clearAll();
            }
        });
        /*
        buttonAllMeals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent AllMealsActivity = new Intent(AddMealActivity.this, com.example.carbgg.AllMealsActivity.class);
                startActivity(AllMealsActivity);
            }
        });
        */
    }

    public void clearAll() {
        EditText editTextMealName = findViewById(R.id.editTextMealName);
        EditText editTextMealCarbs = findViewById(R.id.editTextMealCarbs);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        editTextMealName.clearFocus();
        editTextMealCarbs.clearFocus();

        editTextMealName.setText("");
        editTextMealCarbs.setText("");

        inputMethodManager.hideSoftInputFromWindow(editTextMealCarbs.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }
}