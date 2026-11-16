package com.pluralsight;

import java.math.BigDecimal;

public class House extends Asset {
    private String address;
    private int condition; // 1-excellent, 2-good, 3-fair, 4-poor
    private int squareFoot;
    private int lotSize;

    public House(String description, String dateAcquired, BigDecimal originalCost, String address, int condition, int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    // Helper method to validate condition value
    private static int checkedCondition(int condition) {
        if (condition < 1 || condition > 4) {
            throw new IllegalArgumentException(("Condition must be between 1 and 4."));
        }
        return condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    @Override
    public BigDecimal getValue() {

        int pricePerSquareFoot = switch (condition) {
            case 1 -> 180; // $180.00 per square foot (excellent)
            case 2 -> 130; // $130.00 per square foot (good)
            case 3 -> 90;  // $90.00 per square foot (fair)
            case 4 -> 80;  // $80.00 per square foot (poor)
            default -> throw new IllegalStateException("Unexpected value: " + condition);
        };

        return (BigDecimal.valueOf(pricePerSquareFoot))
                .multiply(BigDecimal.valueOf(squareFoot))
                .add(BigDecimal.valueOf(lotSize)
                        .multiply(BigDecimal.valueOf(0.25))); // PLUS 25 cents per square foot of lot size
    }
}

