package com.pluralsight;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {

    public static ArrayList<Transaction> ledger = BuffReader.getTransaction();


    public static void homeScreen() {

//This is my main class, it serves as my Home Screen.
        do {
            try {

                System.out.println("------------------------------------------");
                System.out.println("Welcome to the Accounting Ledger App!");
                System.out.println("------------------------------------------");
                System.out.println("Please select from the following options:");
                System.out.println(" (D) Add Deposit ");
                System.out.println(" (P) Make Debit Payment ");
                System.out.println(" (L) Ledger ");
                System.out.println(" (X) Exit ");
                System.out.print("Enter Selection: ");

                String selection = Console.PromptForString();

                System.out.println("------------------------------------------");

                if (selection.equalsIgnoreCase("D")) {
                    addDeposit();
                } else if (selection.equalsIgnoreCase("P")) {
                    makePayment();
                } else if (selection.equalsIgnoreCase("L")) {
                    LedgerScreen.ledgerScreen();
                } else if (selection.equalsIgnoreCase("X")) {
                    return;
                } else {
                    System.out.println("Invalid Selection");
                }
            } catch (Exception e) {
                System.out.println("Invalid Selection");
            }
        } while (true);
    }

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

        Transaction t = new Transaction(date, time, description, vendorName, depositAmount);
        Main.ledger.add(t);
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

        Transaction t = new Transaction(date, time, description, vendorName, paymentAmount * -1);
        Main.ledger.add(t);
        BuffReader.saveTransaction();
        System.out.println("Your transaction has been successfully saved! ");

    }

}
