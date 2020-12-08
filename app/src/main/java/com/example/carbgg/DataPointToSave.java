package com.example.carbgg;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class DataPointToSave {
    private Float calculatedCarbs;
    private String dateOfCarbs;


    public DataPointToSave(String dateOfCarbs,float calculatedCarbs) {
        this.dateOfCarbs = dateOfCarbs;
        this.calculatedCarbs = calculatedCarbs;
    }

    public Float getCarbs() {
        return calculatedCarbs;
    }

    public String getTime() {
        return dateOfCarbs;
    }

    @Override
    public String toString() {
        return calculatedCarbs + ", " + dateOfCarbs;
    }
}
