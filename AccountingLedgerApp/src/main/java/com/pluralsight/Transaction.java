package com.pluralsight;
import java.time.LocalDate;
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


    public Transaction(LocalDate date, LocalTime time, String description, String vendor, double depositAmount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.depositAmount = Double.parseDouble(String.valueOf(depositAmount));
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

    public String toString() {
        return "Ledger{" +
                "date=" + date +
                ", time=" + time.format(DateTimeFormatter.ofPattern("HH:mm:ss")) +
                ", description='" + description + '\'' +
                ", vendor='" + vendor + '\'' +
                ", amount=" + depositAmount +
                '}';
    }


}
