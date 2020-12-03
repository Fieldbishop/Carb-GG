package com.example.carbgg;

public class InsulinCalculator extends Settings{

    private float insulinEfficiency;
    private float carbs, carbsDivision;
    private float insulinAmount;


    public InsulinCalculator(float carbs)
    {
        this.carbs = carbs;
        this.insulinEfficiency = super.recallValues();
    }

    public int calculateInsulin(){
        this.carbsDivision = carbs / 10;
        this.insulinAmount = this.carbsDivision / insulinEfficiency;
        return (int)insulinAmount;
    }

}
