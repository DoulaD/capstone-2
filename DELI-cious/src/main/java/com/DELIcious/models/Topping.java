package com.DELIcious.models;

public class Topping {

    private String name;
    private ToppingType type;
    private boolean isExtra;

    public Topping(String name, ToppingType type, boolean isExtra) {
        this.name = name;
        this.type = type;
        this.isExtra = isExtra;
    }
}
