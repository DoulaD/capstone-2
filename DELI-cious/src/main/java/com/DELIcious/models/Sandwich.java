package com.DELIcious.models;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements IOrderItem {

    private String size;
    private String bread;
    private boolean toasted;
    private List<Topping> toppings = new ArrayList<>();
    private List<Sauce> sauces = new ArrayList<>();

    public Sandwich(String size, String bread, boolean toasted, List<Topping> toppings, List<Sauce> sauces) {
        this.size = size;
        this.bread = bread;
        this.toasted = toasted;
        this.toppings = toppings;
        this.sauces = sauces;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);

    }

    public void addSauce(Sauce sauce) {
        sauces.add(sauce);
    }



    @Override
    public String getName() {
        return size + "\" " + bread + " Sandwich" + (toasted ? " (Toasted)" : "");
    }



    @Override
    public double getPrice() {
        double basePrice = switch (size) {
            case "4" -> 5.50;
            case "8" -> 7.00;
            case "12" -> 8.50;
            default -> 0;
        };

        double toppingTotal = 0;
        for (Topping t : toppings) {
            toppingTotal += t.getPriceForSize(size);
        }

        return basePrice + toppingTotal;
    }


}





