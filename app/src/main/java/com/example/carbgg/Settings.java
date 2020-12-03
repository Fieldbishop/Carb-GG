package com.example.carbgg;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class Settings extends MainActivity {
    protected float insulinEfficiency;
    private final String insulinEfficiencyKey = "inEfKey";
    private final String savefile = "configs";

    public Settings(float insulinEfficiency) {
        if(insulinEfficiency > 0){
            this.insulinEfficiency = insulinEfficiency;
        }
        saveValues();
    }
    public Settings(){

    }

    private void saveValues() {
        SharedPreferences prefPutter = getSharedPreferences(savefile, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefPutter.edit();
        prefEditor.putFloat(insulinEfficiencyKey, this.insulinEfficiency);
        prefEditor.commit();
        Log.d("Settings:", "settings updated");
    }

    protected float recallValues() {
        SharedPreferences prefGetter = getSharedPreferences(savefile, Context.MODE_PRIVATE);
        this.insulinEfficiency = prefGetter.getFloat(insulinEfficiencyKey, 1);
        return this.insulinEfficiency;
    }
}
