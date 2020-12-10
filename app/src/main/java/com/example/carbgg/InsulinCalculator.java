package com.example.carbgg;

/**
 * Calculator class for suggested insulin amount
 */
public class InsulinCalculator {
    private float insulinAmount;
    private String insulinDisplay;

    /**
     * Calculates suggested insulin amount by dividing total carbs by 10 and
     * multiplying with insulin coefficient per 10g of carbohydrates
     * @param coefficient Insulin coefficient read from SharedPreferences in Main
     * @param carbs Total amount of carbohydrates of food taken into calculation
     */
    public InsulinCalculator(float coefficient, float carbs){
        if(coefficient == 0){
            coefficient = 1;
        }

        insulinAmount = (carbs / 10) * coefficient;
        insulinDisplay = Float.toString(insulinAmount);
    }

    /**
     * String form of the calculation
     * @return Returns String expression of insulin amount with added text
     */
    public String toString(){
        return "Suggested insulin intake: "+ insulinDisplay+ " units";

    }
}
