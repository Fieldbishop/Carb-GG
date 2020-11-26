package com.example.carbgg;

public class Settings {
    protected int insulinEfficiency;
    protected int constantValue;
    //private final String insulinEfficiencyKey = "inEfKey";
    //ivate final String constantValueKey = "conValKey";

    public Settings(int insulinEfficiency, int constantValue){
        this.insulinEfficiency = insulinEfficiency;
        if(constantValue != 0){
            this.constantValue = constantValue;
        }
    }

    public int getInsulinEfficiency() {
        return insulinEfficiency;
    }
    public int getConstantValue(){
        return constantValue;
    }
}
