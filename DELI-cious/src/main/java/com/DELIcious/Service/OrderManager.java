package com.DELIcious.Service;

import com.DELIcious.models.Order;

import java.util.Scanner;

public class OrderManager {
    private Order currentOrder;

    public void newOrder(Scanner scanner) {
        currentOrder = new Order();
        boolean ordering = true;

        while (ordering) {
            System.out.println("\nOrder Menu");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout ");
            System.out.println("0) Cancel Order");
        }


    }


}
