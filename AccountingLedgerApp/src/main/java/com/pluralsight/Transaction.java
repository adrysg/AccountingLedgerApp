package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Transaction {

    ArrayList<Transaction> ledger = new ArrayList<Transaction>();


    LocalDate date;
    LocalTime time;
    private String description;
    private String vendor;
    private double amount;


    public Transaction(String date, String time, String description, String vendor, double amount) {
        this.date = LocalDate.parse(date);
        this.time = LocalTime.parse(time);
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public String getFormattedDate() {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String getFormattedTime(){
        return time.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public String getDescription() {
        return description;
    }

    public String getVendor() {
        return vendor;
    }

    public double getAmount() {
        return amount;
    }
}
