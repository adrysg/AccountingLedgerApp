package com.pluralsight;

import java.util.ArrayList;

public class Transaction {

    ArrayList<Transaction> ledger = new ArrayList<Transaction>();


    String date;
    String time;
    private String description;
    private String vendor;
    private float amount;


    public Transaction(String date, String time, String description, String vendor, float amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public String getVendor() {
        return vendor;
    }

    public float getAmount() {
        return amount;
    }
}
