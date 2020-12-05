package com.example.carbgg;

import android.app.Application;
import android.content.ClipData;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

class MealViewHolder extends RecyclerView.ViewHolder {
    private final TextView mealItemView;

    private MealViewHolder(View itemView) {
        super(itemView);
        mealItemView = itemView.findViewById(R.id.textView);
        itemView.setOnClickListener(view -> {
            String[] singleMealName = mealItemView.getText().toString().split(", ");
            String[] singleMealCarbsText = singleMealName[1].split(" ");
            int singleMealCarbs = Integer.parseInt(singleMealCarbsText[0]);

            Log.d("MEAL_NAME",singleMealName[0]);
            Log.d("MEAL_CARBS", Integer.toString(singleMealCarbs));

            Intent MainActivity = new Intent(view.getContext(), MainActivity.class);
            MainActivity.putExtra("MEAL_NAME", singleMealName[0]);
            MainActivity.putExtra("MEAL_CARBS", singleMealCarbs);
            view.getContext().startActivity(MainActivity);
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