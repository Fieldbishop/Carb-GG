package com.example.carbgg;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class MealListAdapter extends ListAdapter<Meal, MealViewHolder> {

    public MealListAdapter(@NonNull DiffUtil.ItemCallback<Meal> diffCallback) {
        super(diffCallback);
    }

    @Override
    public MealViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return MealViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(MealViewHolder holder, int position) {
        Meal current = getItem(position);
        holder.bind(current.getMeal());
    }

    static class MealDiff extends DiffUtil.ItemCallback<Meal> {

        @Override
        public boolean areItemsTheSame(@NonNull Meal oldItem, @NonNull Meal newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Meal oldItem, @NonNull Meal newItem) {
            return oldItem.getMeal().equals(newItem.getMeal());
        }
    }
}