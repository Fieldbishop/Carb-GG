package com.example.carbgg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

/**
 * Meal list. Link to add a new meal.
 */

public class SwipeLeft extends AppCompatActivity {
    float x1, x2, y1, y2;

    /**
     * Sets Meals to RecyclerView and shows them in a list. Shows a Snackbar on successful Meal Add.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_left);

        FloatingActionButton newMeal = findViewById(R.id.floatingActionButtonAddMeal);
        newMeal.setOnClickListener(v -> {
            Intent AddMealActivity = new Intent(SwipeLeft.this, com.example.carbgg.AddMealActivity.class);
            startActivity(AddMealActivity);
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final MealListAdapter adapter = new MealListAdapter(new MealListAdapter.MealDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MealViewModel mMealViewModel = new ViewModelProvider(this).get(MealViewModel.class);

        mMealViewModel.getAllMeals().observe(this, meals -> adapter.submitList(meals));

        if (getIntent().hasExtra("SUCCESS")) {
            Snackbar successSnack = Snackbar.make(findViewById(R.id.activity_swipe_left), R.string.meal_saved, Snackbar.LENGTH_LONG);
            successSnack.show();
        }
    }

    public boolean onTouchEvent(MotionEvent touchevent){
        switch (touchevent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = touchevent.getX();
                y1 = touchevent.getY();
                break;

            case MotionEvent.ACTION_UP:
                x2 = touchevent.getX();
                y2 = touchevent.getY();
                if (x1 > x2) {
                    Intent i = new Intent(SwipeLeft.this, MainActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                }
                break;
        }
        return false;
    }
    public void btnCalculator(View view){
        Intent j = new Intent(SwipeLeft.this,MainActivity.class);
        startActivity(j);
    }
    public void btnHistory(View view){
        Intent j = new Intent(SwipeLeft.this,SwipeRight.class);
        startActivity(j);
    }
}