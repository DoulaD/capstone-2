package com.DELIcious.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderRecepit {
    public static void saveReceipt(Order order){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String fileName = "receipts/" + LocalDateTime.now().format(formatter) + ".txt";
    }
}
