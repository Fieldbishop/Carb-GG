package com.example.carbgg;

public class InsulinCalculator extends Settings{

    private float insulinEfficiency;
    private float carbs, carbsDivision;
    private float insulinAmount;


    public InsulinCalculator(int carbs)
    {
        this.carbs = (float)carbs;
        this.insulinEfficiency = super.insulinEfficiency;
    }

    public int calculateInsulin(){
        this.carbsDivision = carbs / 10;
        this.insulinAmount = this.carbsDivision / insulinEfficiency;
        return  (int)insulinAmount;
    }

}
