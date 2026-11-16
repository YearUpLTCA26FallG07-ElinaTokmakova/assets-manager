package com.pluralsight;

import java.math.BigDecimal;

public class House extends Asset{
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
        BigDecimal pricePerSquareFoot;
        // A house's value is determined as
        // $180.00 per square foot (excellent)
        // $130.00 per square foot (good)
        // $90.00 per square foot (fair)
        // $80.00 per square foot (poor)
        // PLUS 25 cents per square foot of lot size
        switch (condition) {
            case 1 -> {
                pricePerSquareFoot = BigDecimal.valueOf(180);
            }
            case 2 ->{
                pricePerSquareFoot = BigDecimal.valueOf(130);
            }
            case 3 -> {
                pricePerSquareFoot = BigDecimal.valueOf(90);
            }
            case 4 -> {
               pricePerSquareFoot = BigDecimal.valueOf(80);
            }
            default -> {
                System.out.println("Something went wrong");
                return null;
            }
        }
        return pricePerSquareFoot.multiply(BigDecimal.valueOf(squareFoot)).add(BigDecimal.valueOf(lotSize).multiply(BigDecimal.valueOf(0.25)));
    }
}

