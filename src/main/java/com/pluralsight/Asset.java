package com.pluralsight;

import java.math.BigDecimal;

public class Asset {
    private String description;
    private String dateAcquired;
    private BigDecimal originalCost;

    public Asset(String description, String dateAcquired, BigDecimal originalCost) {
        this.description = description;
        this.dateAcquired = dateAcquired;
        this.originalCost = originalCost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateAcquired() {
        return dateAcquired;
    }

    public void setDateAcquired(String dateAcquired) {
        this.dateAcquired = dateAcquired;
    }

    public BigDecimal getOriginalCost() {
        return originalCost;
    }

    public void setOriginalCost(BigDecimal originalCost) {
        this.originalCost = originalCost;
    }

    public BigDecimal getValue() {
        return this.originalCost;
    }
    // A house's value is determined as
    // $180.00 per square foot (excellent)
    // $130.00 per square foot (good)
    // $90.00 per square foot (fair)
    // $80.00 per square foot (poor)
    // PLUS 25 cents per square foot of lot size
}
