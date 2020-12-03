package com.example.carbgg;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class Settings{
    protected int insulinEfficiency;
    private final String insulinEfficiencyKey = "inEfKey";
    private Context context;

    public Settings(int insulinEfficiency, Context context){
        this.insulinEfficiency = insulinEfficiency;
        this.context = context;
        saveValues();
    }

    private void saveValues(){
        SharedPreferences prefPutter = context.getSharedPreferences(insulinEfficiencyKey, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefPutter.edit();
        prefEditor.putInt(insulinEfficiencyKey, this.insulinEfficiency);
        prefEditor.commit();
        Log.d("Settings:", "settings updated");
    }
    protected void recallValues(){
        SharedPreferences prefGetter = context.getSharedPreferences(insulinEfficiencyKey, Context.MODE_PRIVATE);
        this.insulinEfficiency = prefGetter.getInt(insulinEfficiencyKey,0);

    }
    protected int getInsulinEfficiency(){
        return insulinEfficiency;
    }
}
