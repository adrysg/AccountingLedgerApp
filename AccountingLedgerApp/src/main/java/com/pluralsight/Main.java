package com.pluralsight;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import static com.pluralsight.BuffReader.getTransaction;
import static com.pluralsight.Console.PromptForString;


public class Main {
    public final static File fileName = new File("Transactions.csv");
    public static ArrayList<Transaction> ledger = getTransaction();

    public static void main(String[] args){
        homeScreen();
    }

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

                String selection = PromptForString();

                System.out.println("------------------------------------------");

                // mapping user selection with its corresponding method.

                if (selection.equalsIgnoreCase("D")) {
                    addDeposit();
                } else if (selection.equalsIgnoreCase("P")) {
                    makePayment();
                } else if (selection.equalsIgnoreCase("L")) {
                    LedgerScreen.ledgerScreen();
                } else if (selection.equalsIgnoreCase("X")) {
                    System.out.println("Thank you for using Accounting Ledger App!");
                    return;
                } else {
                    System.out.println("Invalid Selection");
                }
            } catch (Exception e) {
                System.out.println("Invalid Selection");
            }
        } while (true);
    }

    //These are my home screen functions,
    // these methods allow the user to add a deposit or make a payment.

    public static void addDeposit() {
        //prompt user for deposit info and save to csv file
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        System.out.print("Please enter a deposit description: ");
        String description = Console.PromptForString();
        System.out.print("Please enter your deposit amount: ");
        double depositAmount = Console.PromptForDouble();
        System.out.print("Please enter vendor name: ");
        String vendorName =Console.PromptForString();

        System.out.println();
        System.out.println("Here is your deposit information: ");
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
        System.out.println("Description: " + description);
        System.out.printf("Deposit Amount: " + "%.2f", depositAmount);
        System.out.println("\nVendor: " + vendorName);

        Transaction t = new Transaction(date, time, description, vendorName, depositAmount);
        ledger.add(t);
        saveTransaction();
        System.out.println("\nYour transaction has been successfully saved! ");

    }

    public static void makePayment() {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        System.out.print("Please enter payment description: ");
        String description = PromptForString();
        System.out.print("Please enter your payment amount: ");
        double paymentAmount = Console.PromptForDouble();
        System.out.print("Please enter vendor name: ");
        String vendorName = PromptForString();


        System.out.println("Here is your deposit information: ");
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
        System.out.println("Description: " + description);
        System.out.printf("Payment Amount: " + "%.2f", paymentAmount);
        System.out.println("\nVendor: " + vendorName);

        Transaction t = new Transaction(date, time, description, vendorName, paymentAmount * -1);
        ledger.add(t);
        saveTransaction();
        System.out.println("Your transaction has been successfully saved! ");

    }

    public static void saveTransaction () {

        try {

            FileWriter fw = new FileWriter(fileName);

            for (Transaction t : ledger) {
                String data = t.getFormattedDate()
                        + "|" + t.getFormattedTime() + "|" + t.getDescription() + "|"
                        + t.getVendor() + "|" + t.getAmount() + "\n";
                fw.write(data);
            }

            fw.close();
        } catch (Exception e) {
            System.out.println("FILE WRITE ERROR");
        }

    }

}
