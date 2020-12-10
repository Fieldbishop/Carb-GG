package com.example.carbgg;

/**
 * class for creating objects for singleton arraylist "SingletonClassHistory"
 * @author Jaakko Nahkala, Riku Immonen and Lassi Piispanen
 */
public class DataPointToSave {
    private Float calculatedCarbs;
    private String dateOfCarbs;

    /**
     * @param dateOfCarbs date of taking the datapoint
     * @param calculatedCarbs combined carbohydrate intake for a calculation
     */
    public DataPointToSave(String dateOfCarbs,float calculatedCarbs) {
        this.dateOfCarbs = dateOfCarbs;
        this.calculatedCarbs = calculatedCarbs;
    }

    /**
     * @return Carbs
     */
    public Float getCarbs() {
        return calculatedCarbs;
    }

    /**
     * @return Time
     */
    public String getTime() {
        return dateOfCarbs;
    }

    /**
     * @return "carbs, date" in string format
     */
    @Override
    public String toString() {
        return calculatedCarbs + ", " + dateOfCarbs;
    }
}
