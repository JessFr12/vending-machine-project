package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VendingMachineLogger {
    private PrintWriter writer;
    public VendingMachineLogger() throws FileNotFoundException {
        this.writer = new PrintWriter(new File("Log.txt"));
    }

    public void logTransaction(String action, double amount, double balance) {
        LocalDateTime timestamp = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyy hh:mm:ss");
        String formattedTimestamp = timestamp.format(formatter);
    }
    public void logFeedMoney(double amount, double balance) {
        logTransaction("Feed Money", amount, balance);
    }



}

