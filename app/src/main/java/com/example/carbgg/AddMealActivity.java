package com.example.carbgg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

/**
 * Adds meal to database
 * @author Jaakko Nahkala, Riku Immonen and Lassi Piispanen
 */

public class AddMealActivity extends AppCompatActivity {

    /**
     * Creates the page layout. Helps user to fill out the forms by giving feedback on missing items
     * etc. Adds meal to database. Sends user back to previous page after hitting "Submit".
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meal);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        EditText editTextMealName = findViewById(R.id.editTextMealName);
        EditText editTextMealCarbs = findViewById(R.id.editTextMealCarbs);
        Button buttonSave = findViewById(R.id.buttonSave);

        MealRoomDatabase db = MealRoomDatabase.getDatabase(this.getApplicationContext());
        MealDao mMealDao = db.mealDao();

        buttonSave.setOnClickListener(view -> {
            if (TextUtils.isEmpty(editTextMealName.getText()) || TextUtils.isEmpty(editTextMealCarbs.getText())) {
                    if (TextUtils.isEmpty(editTextMealName.getText()) && !TextUtils.isEmpty(editTextMealCarbs.getText())) {
                        editTextMealName.setError("Please add meal name");
                        editTextMealName.requestFocus();
                    }
                    else if (TextUtils.isEmpty(editTextMealCarbs.getText()) && !TextUtils.isEmpty((editTextMealName.getText()))) {
                        editTextMealCarbs.setError("Please add carbohydrate amount");
                        editTextMealCarbs.requestFocus();
                    }
                    else {
                        editTextMealName.setError("Please add meal name");
                        editTextMealCarbs.setError("Please add carbohydrate amount");
                        editTextMealName.requestFocus();
                    }
            } else {
                String mealName = editTextMealName.getText().toString();
                float mealCarbs = Float.parseFloat(editTextMealCarbs.getText().toString());

                Meal meal = new Meal(mealName, mealCarbs, "");

                MealRoomDatabase.databaseWriteExecutor.execute(() -> {
                    mMealDao.insert(meal);
                });

                Intent SwipeLeftActivity = new Intent(AddMealActivity.this, SwipeLeft.class);
                SwipeLeftActivity.putExtra("SUCCESS", 1);
                startActivity(SwipeLeftActivity);
            }
        });
    }

    /**
     * Returns the user to previous page.
     */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}