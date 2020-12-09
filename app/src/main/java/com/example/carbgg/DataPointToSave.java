package com.example.carbgg;

/**
 * class for creating objects for singleton arraylist "SingletonClassHistory"
 */
public class DataPointToSave {
    private Float calculatedCarbs;
    private String dateOfCarbs;

    /**
     * constructor
     * @param dateOfCarbs date of taking the datapoint
     * @param calculatedCarbs combined carbohydrate intake of a calculation
     */
    public DataPointToSave(String dateOfCarbs,float calculatedCarbs) {
        this.dateOfCarbs = dateOfCarbs;
        this.calculatedCarbs = calculatedCarbs;
    }

    /**
     * getCarbs
     * @return Carbs
     */
    public Float getCarbs() {
        return calculatedCarbs;
    }

    /**
     * getTime
     * @return Time
     */
    public String getTime() {
        return dateOfCarbs;
    }

    /**
     * toString method
     * @return carbs, date in string format
     */
    @Override
    public String toString() {
        return calculatedCarbs + ", " + dateOfCarbs;
    }
}
