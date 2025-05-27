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

            String choice = scanner.nextLine();

            switch (choice) {
                case "1 New Order":
                    orderManager.newOrder(scanner);
                    break;
                case "0 Exit" :
                    System.out.println("Thank you for using DELI-cious!");
                    return;
                default:
                    System.out.println("Invalid choice.");


            }


        }

    }
}
