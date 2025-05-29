package com.DELIcious.ui;

import com.DELIcious.Service.Order;
import com.DELIcious.Service.OrderReceipt;
import com.DELIcious.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private Order currentOrder;

    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("\n==== DELI-cious POS ====");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    createNewOrder();
                    break;
                case "0":
                    System.out.println("Thank you! Goodbye.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void createNewOrder() {
        currentOrder = new Order();

        boolean ordering = true;
        while (ordering) {
            System.out.println("\n--- Order Menu ---");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");

            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println();
                    addSandwich();
                    break;
                case "2":
                    System.out.println();
                    addDrink();
                    break;
                case "3":
                    System.out.println();
                    addChips();
                    break;
                case "4":
                    checkout();
                    ordering = false;
                    break;
                case "0":
                    System.out.println("Order canceled. Returning to Home.");
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void checkout() {
        System.out.println("\n==== Checkout ====");
        System.out.println(currentOrder.getOrderDetails());
        System.out.print("Confirm order? (Y/N): ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("Y")) {
            System.out.println();
             OrderReceipt.saveReceipt(currentOrder);
        } else {
            System.out.println("Order not confirmed. Returning to home.");
        }
    }

    private void addSandwich() {
        System.out.println("\n=== Build Your Sandwich ===");

        //  Choose size
        System.out.print("Choose a size (4, 8, 12): ");
        String size = scanner.nextLine();

        //  Choose bread
        System.out.print("Choose bread (white, wheat, rye, sourdough, wrap): ");
        String bread = scanner.nextLine();

        //  Toasted?
        System.out.print("Would you like it toasted? (Y/N): ");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("Y");

        //  premium toppings
        List<Topping> toppings = new ArrayList<>();
        System.out.println("\nAdd premium toppings (meat/cheese). Type 'done' to finish.");
        while (true) {
            System.out.print("Enter premium topping (steak, ham, bacon, cheddar, swiss, etc): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) break;

            System.out.print("Is this an extra portion? (Y/N): ");
            boolean isExtra = scanner.nextLine().equalsIgnoreCase("Y");

            // Meat and cheese are premium
            boolean isPremium = true;
            toppings.add(new Topping(name, isPremium, isExtra));
        }

        //  regular toppings
        System.out.println("\nAdd regular toppings (lettuce, tomato, onions, etc). Type 'done' to finish.");
        while (true) {
            System.out.print("Enter topping: ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) break;

            boolean isPremium = false;
            boolean isExtra = false;
            toppings.add(new Topping(name, isPremium, isExtra));
        }

        //  sauces
        List<Sauce> sauces = new ArrayList<>();
        System.out.println("\nAdd sauces (mayo, mustard, ranch, etc). Type 'done' to finish.");
        while (true) {
            System.out.print("Enter sauce: ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) break;

            sauces.add(new Sauce(name));
        }

        //  sandwich create and add to order
        Sandwich sandwich = new Sandwich(size, bread, toasted, toppings, sauces);
        currentOrder.addItem(sandwich);

        System.out.println("\nSandwich added to order: " + sandwich.getName());
    }

    private void addDrink() {
        System.out.println("\n==== Add Drink =====");

        System.out.println("Choose drink size(Small, Medium, Large):");
        String size = scanner.nextLine().trim().toLowerCase();

        System.out.println("Choose drink flavor (Lemon-berry, Citrus-punch, Iced-tea");
        String flavor = scanner.nextLine().trim();
        Drink drink = new Drink(size, flavor);
        currentOrder.addItem(drink);

        System.out.println("Added drink: " + drink.getName());
        System.out.printf("price: $%.2f\n", drink.getPrice());

    }

    private void addChips() {
        System.out.println("\n======  Add Chips =====");

        System.out.println("Enter chip type (BBQ, sour cream, classic, kettle");
        String type = scanner.nextLine().trim();

        Chip chip = new Chip(type);
        currentOrder.addItem(chip);
    }

}



