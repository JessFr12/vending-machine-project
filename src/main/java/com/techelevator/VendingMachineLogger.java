package com.techelevator;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VendingMachineLogger {
    private  PrintWriter writer;
    public VendingMachineLogger() throws IOException {
//        the second true auto filled not completely sure why
        writer = new PrintWriter(new FileWriter("Log.txt", true), true);
    }

    public void logTransaction(String action, double amount, double balance) {
        LocalDateTime timestamp = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyy hh:mm:ss");
        String formattedTimestamp = timestamp.format(formatter);
        writer.println(formattedTimestamp + " " + action + ": $" + amount + " $" + balance);
    }
    public void logFeedMoney(double amount, double balance) {
        logTransaction("Feed Money", amount, balance);
    }
    public void logPurchase(String id, double amount, double balance) {
        logTransaction(id, amount, balance);
    }
    public void logGiveChange(double amount, double balance) {
        logTransaction("Give Change", amount, balance);
    }

}

