package com.DELIcious.models;

public class Chip implements IOrderItem {

private String type;
private static final double price = 1.50;

    public Chip(String type) {
        this.type = type;
    }



    @Override
    public String getName() {
        return type + "Chips";
    }

    @Override
    public double getPrice() {
        return price;
    }


}
