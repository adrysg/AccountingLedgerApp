package com.pluralsight;
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

    public final static String fileName = "Transactions.csv";
    public static ArrayList<Transaction> ledger = new ArrayList<Transaction>();
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws IOException {

        // read from the file and populate the arraylist.
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Transactions.csv"));

            while ((reader.readLine()) != null) {
                reader.readLine();
            }
            reader.close();

        } catch (IOException e) {
        }
        //Create a home screen
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

                String selection = scanner.nextLine();

                System.out.println("------------------------------------------");

                if (selection.equalsIgnoreCase("D")) {
                    addDeposit();
                } else if (selection.equalsIgnoreCase("P")) {
                    makePayment();
                } else if (selection.equalsIgnoreCase("L")) {
                    ledgerScreen();
                } else if (selection.equalsIgnoreCase("X")) {
                    return;
                } else {
                    System.out.println("Invalid Selection");
                }
            } catch (Exception e) {
                System.out.println("Invalid Selection");
            }
        }

    public static void addDeposit() {
        //prompt user for deposit info and save to csv file
        System.out.print("Please enter a brief description: ");
        String description = scanner.nextLine();
        System.out.print("Please enter your deposit amount: ");
        float deposit = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Here is your deposit information: ");
        System.out.println("Description: " + description);
        System.out.printf("Deposit Amount: " + "%.2f", deposit);
        System.out.println("\nName: " + name);
        //next steps - we have this information, what do we do with it?

    }

    public static void makePayment() {
        //prompt user for debit info and save to csv file
        System.out.print("Please enter your payment amount: ");
        double amount = scanner.nextDouble();
        System.out.print("Please enter your debit information: ");
        int info = scanner.nextInt();
    }

    public static void ledgerScreen() {
        //display ledger screen
        System.out.println("Welcome to your Ledger Screen! ");
        System.out.println("------------------------------------------");
        System.out.println("Please make a selection: ");
        System.out.println(" (A) All entries");
        System.out.println(" (D) Deposits ");
        System.out.println(" (P) Payments ");
        System.out.println(" (R) Reports ");
        System.out.println(" (H) Home ");
        System.out.print("Enter (A), (B), (P), (R) or (H): ");
        String selection = scanner.nextLine();

        System.out.println("------------------------------------------");

        if (selection.equalsIgnoreCase("A")) {
            //display all entries
            //loop through the arraylist to show all entries.
            System.out.println("All entries are listed below:\n ");

            try {
                BufferedReader reader = new BufferedReader(new FileReader("Transactions.csv"));
                String line;

                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                reader.close();
            } catch (IOException e) {}
        }
        else if (selection.equalsIgnoreCase("D")) {
            //display deposit only entries
        }
        else if (selection.equalsIgnoreCase("P")) {
            //display payments only(negative entries)
        }
        else if (selection.equalsIgnoreCase("R")) {
            /*display new screen allowing user to run pre-defined reports or custom search
             * 1) month to date
             * 2) previous month
             * 3) year to date
             * 4) previous year
             * 5) search by vendor (prompt user for vendor name and display entries)
             * 0) back (go back to report page)
             */
        }
        else if (selection.equalsIgnoreCase("H")) {
            return;
        }
        System.out.println("------------------------------------------");

    }
}



