package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;

public class HomeFunctions {

    public static void addDeposit() {
        //prompt user for deposit info and save to csv file
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        System.out.print("Please enter a deposit description: ");
        String description = Console.PromptForString();
        System.out.print("Please enter your deposit amount: ");
        double depositAmount = Console.PromptForDouble();
        System.out.print("Please enter vendor name: ");
        String vendorName = Console.PromptForString();

        System.out.println();
        System.out.println("Here is your deposit information: ");
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
        System.out.println("Description: " + description);
        System.out.printf("Deposit Amount: " + "%.2f", depositAmount);
        System.out.println("\nVendor: " + vendorName);

        Transaction t = new Transaction(date, time, description,vendorName, depositAmount);
        AccountingLedgerApp.ledger.add(t);
        BuffReader.saveTransaction();
        System.out.println("\nYour transaction has been successfully saved! ");

    }

    public static void makePayment() {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        System.out.print("Please enter payment description: ");
        String description = Console.PromptForString();
        System.out.print("Please enter your payment amount: ");
        double paymentAmount = Console.PromptForDouble();
        System.out.print("Please enter vendor name: ");
        String vendorName = Console.PromptForString();


        System.out.println("Here is your deposit information: ");
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
        System.out.println("Description: " + description);
        System.out.printf("Payment Amount: " + "%.2f", paymentAmount);
        System.out.println("\nVendor: " + vendorName);

        Transaction t = new Transaction(date, time, description,vendorName, paymentAmount * -1);
        AccountingLedgerApp.ledger.add(t);
        BuffReader.saveTransaction();
        System.out.println("Your transaction has been successfully saved! ");

    }



}
