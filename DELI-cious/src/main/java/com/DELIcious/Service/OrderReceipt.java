package com.DELIcious.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderReceipt {
    public static void saveReceipt(Order order){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd-HHmmss");
        String fileName = "receipts/" + LocalDateTime.now().format(formatter) + ".txt";


        try (FileWriter Writer = new FileWriter ("src/receipts")) {
            Writer.write(order.getOrderDetails());
            System.out.println("Receipt saved to : " + fileName);
        }
        catch (IOException e){
            System.out.println("Failed to save receipt:  " + e.getMessage());

        }
    }

}
