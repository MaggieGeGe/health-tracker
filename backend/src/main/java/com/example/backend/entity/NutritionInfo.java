package com.example.backend.entity;

import lombok.Data;

@Data
public class NutritionInfo {
    private double calories;
    private double serving_size_g;
    private double protein_g;
    private double carbohydrates_total_g;
    private double fiber_g;
    private double sugar_g;
    private double fat_total_g;
    private double fat_saturated_g;
    private double cholesterol_mg;
    private double sodium_mg;
    private double potassium_mg;
}
