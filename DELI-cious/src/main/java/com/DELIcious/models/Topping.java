package com.DELIcious.models;

public class Topping {

    private String name;
    private boolean isExtra;
    private boolean isPremium;



    public Topping(String name, boolean isExtra, boolean isPremium) {
        this.name = name;
        this.isExtra = isExtra;
        this.isPremium = isPremium;
    }
    public double getPriceForSize(String size) {
        if (!isPremium) return 0; // regular toppings are free

        double basePrice = switch (name.toLowerCase()) {
            case "steak", "turkey", "fish", "roast beef", "chicken", "falafel" -> switch (size) {
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

