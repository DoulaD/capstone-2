package com.DELIcious.models;

public class Topping {

    private String name;
    private boolean isPremium;
    private boolean isExtra;



    public Topping(String name, boolean isPremium, boolean isExtra) {
        this.name = name;
        this.isExtra = isExtra;
        this.isPremium = isPremium;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public double getPriceForSize(String size) {
        if (!isPremium) return 0; // regular toppings are free

        double basePrice = switch (name.toLowerCase()) {
            case "steak", "ham", "bacon", "roast beef", "chicken", "salami" -> switch (size) {
                case "4" -> 1.00;
                case "8" -> 2.00;
                case "12" -> 3.00;
                default -> 0.0;
            };
            case "cheese", "american", "cheddar", "provolone", "swiss" , "pepper jack" -> switch (size) {
                case "4" -> 0.75;
                case "8" -> 1.50;
                case "12" -> 2.25;
                default -> 0.0;
            };
            default -> 0.0;
        };

        double extraCharge = 0;
        if (isExtra) {
            extraCharge = switch (name.toLowerCase()) {
                case "steak", "ham", "salami", "roast beef", "chicken", "bacon" -> switch (size) {
                    case "4" -> 0.50;
                    case "8" -> 1.00;
                    case "12" -> 1.50;
                    default -> 0.0;
                };
                case "cheese", "american", "cheddar", "provolone", "swiss" -> switch (size) {
                    case "4" -> 0.30;
                    case "8" -> 0.60;
                    case "12" -> 0.90;
                    default -> 0.0;
                };
                default -> 0.0;
            };
        }

        return basePrice + extraCharge;
    }

    public String getName() {
        return name + (isExtra ? " (extra)" : "");
    }
 }

