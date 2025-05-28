package com.DELIcious.models;

public class Drink implements IOrderItem{

    private String size;
    private String flavor;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }



    @Override
    public String getName() {
        return size + " " + flavor + " Drink";
    }

    @Override
    public double getPrice() {
        return switch (size.toLowerCase()) {
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> 0.0;
        };
    }
}


