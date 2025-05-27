package com.DELIcious;

import com.DELIcious.Service.OrderManager;

import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner = new Scanner(System.in);
    private final OrderManager orderManager = new OrderManager();

    public void start() {
        while (true) {

            System.out.println("Welcome to DELI-cious!");
            System.out.println("1) New Order");
            System.out.println("0 Exit");

            String Choice = scanner.nextLine();

            Switch (choice){


        }

    }
}
