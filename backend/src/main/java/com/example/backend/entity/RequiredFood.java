package com.example.backend.entity;

import lombok.Data;

import java.math.BigDecimal;


public class RequiredFood {
    private String name;
    private FoodType type;
    private NutritionInfo nutrition;
    private BigDecimal amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FoodType getType() {
        return type;
    }


    public void setType(String type) {
        this.type = FoodType.valueOf(type.toUpperCase());
    }

    public NutritionInfo getNutrition() {
        return nutrition;
    }

    public void setNutrition(NutritionInfo nutrition) {
        this.nutrition = nutrition;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
