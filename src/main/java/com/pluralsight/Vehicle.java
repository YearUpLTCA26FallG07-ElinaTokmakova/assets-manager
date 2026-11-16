package com.pluralsight;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;

public class Vehicle extends Asset {
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, BigDecimal originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public BigDecimal getValue() {
        int today = Year.now().getValue();
        int vehicleAge = Math.max(0, (today - year));
        BigDecimal depreciation;

        if (0 <= vehicleAge && vehicleAge <= 3) {
            depreciation = BigDecimal.valueOf(0.03);
        } else if (4 <= vehicleAge && vehicleAge <= 6) {
            depreciation = BigDecimal.valueOf(0.06);
        } else if (7 <= vehicleAge && vehicleAge <= 10) {
            depreciation = BigDecimal.valueOf(0.08);
        } else if (vehicleAge > 10) {
            return BigDecimal.valueOf(1000.00);
        }

        BigDecimal value = Math.pow(BigDecimal.valueOf(100).subtract(BigDecimal.valueOf(depreciation))
                .divide(BigDecimal.valueOf(100)));
        return value;
    }
    // A car's value is determined as
    // 0-3 years old - 3% reduced value of cost per year
    // 4-6 years old - 6% reduced value of cost per year
    // 7-10 years old - 8% reduced value of cost per year
    // over 10 years old - $1000.00
    // MINUS reduce final value by 25% if over 100,000 miles
    // unless makeModel contains word Honda or Toyota
    // final cost = initial value * ((100 - depreciation rate) / 100) to the power of the number of years
}
