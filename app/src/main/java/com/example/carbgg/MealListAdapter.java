package com.example.carbgg;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

/**
 * Adapter for recyclerview "MealList"
 * @author Jaakko Nahkala, Riku Immonen and Lassi Piispanen
 */
public class MealListAdapter extends ListAdapter<Meal, MealViewHolder> {

    /**
     * Makes the MealList show instant updates.
     * @param diffCallback "Callback that informs <code>ArrayObjectAdapter</code> how to compute list
     *                     updates."
     *                     <a href="https://developer.android.com/reference/androidx/leanback/widget/DiffCallback">
     *                     Android Documentation</a>
     */

    public MealListAdapter(@NonNull DiffUtil.ItemCallback<Meal> diffCallback) {
        super(diffCallback);
    }

    @Override
    public MealViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return MealViewHolder.create(parent);
    }

    /**
     * Gets the current Meal object and binds it to holder.
     */

    @Override
    public void onBindViewHolder(MealViewHolder holder, int position) {
        Meal current = getItem(position);
        holder.bind(current.getMeal());
    }

    /**
     * Updates list instantly according to changes.
     */

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