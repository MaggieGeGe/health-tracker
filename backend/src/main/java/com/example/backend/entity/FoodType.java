package com.example.backend.entity;

public enum FoodType {
    VEGETABLE("vegetables"),
    FRUIT("fruits"),
    GRAINBEANNUTS("grain bean and nuts"),
    MEAT("meat"),
    SEAFOOD("seafood"),
    DAIRY("dairy");


    private String label;

    FoodType(String label) {
        this.label = label;
    }

    public String getLabel(){
        return label;
    }
}
