package com.DELIcious.Service;

import com.DELIcious.models.IOrderItem;
import com.DELIcious.models.Sandwich;
import com.DELIcious.models.Sauce;
import com.DELIcious.models.Topping;


import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<IOrderItem> items = new ArrayList<>();

    public void addItem(IOrderItem item) {

        items.add(item);
    }

    public List<IOrderItem> getItems() {
        return items;
    }

    public double getTotal() {

        double total = 0;
        for (IOrderItem item : items)
            total += item.getPrice();

        return total;
    }

    public String getOrderDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("===========>  Your Order  <==========\n");

        for (IOrderItem item : items) {
            sb.append(String.format("%-30s $%.2f\n", item.getName(), item.getPrice()));

            if (item instanceof Sandwich sandwich) {

                if (!sandwich.getToppings().isEmpty()) {
                    sb.append("Toppings: \n");


                    for (Topping t : sandwich.getToppings()) {
                        double price = t.getPriceForSize(sandwich.getSize());
                        sb.append(String.format("   -%20s $%.2f\n", t.getName(), price));
                    }


                }

                if (!sandwich.getSauces().isEmpty()) {
                    sb.append("   Sauces:  ");
                    for (Sauce s : sandwich.getSauces()) {
                        sb.append("     - ").append(s.getName()).append("\n ");
                    }
                }
            }


        }


        sb.append("-----------------------------------\n");
        sb.append(String.format("TOTAL:                         $%.2f\n", getTotal()));
        sb.append("===================================\n");

        return sb.toString();
    }
}