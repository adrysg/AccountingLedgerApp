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
    public String description;
    public String vendor;
    public double depositAmount;


    public Transaction(String date, String time, String description, String vendor, double depositAmount) {
        this.date = LocalDate.parse(date);
        this.time = LocalTime.parse(time);
        this.description = description;
        this.vendor = vendor;
        this.depositAmount = Double.parseDouble(String.valueOf(depositAmount));
    }

    public Transaction(String date, String time, String description, double depositAmount, String vendorName) {
        getFormattedDate();
        getFormattedTime();
        getDescription();
        getVendor();

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
        return depositAmount;
    }
}
