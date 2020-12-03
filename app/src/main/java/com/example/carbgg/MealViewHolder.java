package com.example.carbgg;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

class MealViewHolder extends RecyclerView.ViewHolder {
    private final TextView mealItemView;

    private MealViewHolder(View itemView) {
        super(itemView);
        mealItemView = itemView.findViewById(R.id.textView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = getAdapterPosition();
                Log.d("adapterPosition", Integer.toString(i));
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(intent);
            }
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