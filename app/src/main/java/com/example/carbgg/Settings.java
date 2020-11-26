package com.example.carbgg;

import android.content.Context;
import android.content.SharedPreferences;

public class Settings{
    protected int insulinEfficiency;
    protected int constantValue;
    private final String insulinEfficiencyKey = "inEfKey";
    private final String constantValueKey = "conValKey";

    public Settings(){

    }
    public Settings(int insulinEfficiency, int constantValue){
        this.insulinEfficiency = insulinEfficiency;
        this.constantValue = constantValue;

        saveValues();
    }

    private void saveValues(){

    }
    protected void recallValues(){
        //SharedPreferences prefGetter = getSharedPreferences(insulinEfficiencyKey,Context.MODE_PRIVATE);
    }

    protected int getInsulinEfficiency(){
        return insulinEfficiency;
    }
    protected int getConstantValue(){
        return constantValue;
    }
}
