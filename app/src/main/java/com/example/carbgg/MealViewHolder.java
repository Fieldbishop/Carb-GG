package com.example.carbgg;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


class MealViewHolder extends RecyclerView.ViewHolder {
    private final TextView mealItemView;

    private MealViewHolder(View itemView) {
        super(itemView);
        mealItemView = itemView.findViewById(R.id.textView);

        ImageButton deleteButton = itemView.findViewById(R.id.imageButtonDeleteItem);

        MealRoomDatabase db = MealRoomDatabase.getDatabase(itemView.getContext());
        MealDao mMealDao = db.mealDao();
        itemView.setOnClickListener(view -> {
            String[] singleMealName = mealItemView.getText().toString().split(", ");
            String[] singleMealCarbsText = singleMealName[1].split(" ");
            int singleMealCarbs = Integer.parseInt(singleMealCarbsText[0]);

            Log.d("MEAL_NAME",singleMealName[0]);
            Log.d("MEAL_CARBS", Integer.toString(singleMealCarbs));

            ListToSend.getInstance().addMeal(singleMealName[0],singleMealCarbs,"");
        });

        deleteButton.setOnClickListener(view -> {
            String[] singleMealName = mealItemView.getText().toString().split(", ");
            MealRoomDatabase.databaseWriteExecutor.execute(() -> {
                mMealDao.deleteMeal(singleMealName[0]);
            });
        });
    }

    public void bind(String text) {
        mealItemView.setText(text);
    }

    static MealViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new MealViewHolder(view);
    }
}