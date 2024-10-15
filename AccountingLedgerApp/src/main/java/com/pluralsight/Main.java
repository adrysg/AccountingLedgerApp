package com.pluralsight;
import java.io.BufferedReader;
import java.util.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;



public class Main {
    static Scanner scanner = new Scanner(System.in);
    public final static String fileName = "transactions.csv";
    public static ArrayList<Transaction> ledger = new ArrayList<Transaction>();

    public static void main(String[] args) {

        // read from the file and populate the arraylist.

        try {

            FileReader fr = new FileReader("transactions.csv");
            BufferedReader bf = new BufferedReader(fr);
            bf.readLine();

//Create a home screen
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
            }
            else if (selection.equalsIgnoreCase("P")) {
                makePayment();
            }
            else if (selection.equalsIgnoreCase("L")) {
                ledgerScreen();
            }
            else if (selection.equalsIgnoreCase("X")) {
                return;
            }
            else {
                System.out.println("Invalid Selection");
            }
        } catch (Exception e) {
            System.out.println("Invalid Selection");
        }
    }
    public static void addDeposit () {
        //prompt user for deposit info and save to csv file
        System.out.print("Please enter a brief description: ");
        String description = scanner.nextLine();
        System.out.print("Please enter your deposit amount: ");
        double deposit = scanner.nextDouble();
        System.out.print("Please enter your account number: ");
        int account = scanner.nextInt();

        //next steps - we have this information, what do we do with it?

    }

    public static void makePayment () {
        //prompt user for debit info and save to csv file
        System.out.print("Please enter your payment amount: ");
        double amount = scanner.nextDouble();
        System.out.print("Please enter your debit information: ");
        int info = scanner.nextInt();
    }

    public static void ledgerScreen () {
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
        switch (selection) {
            case "A" -> {
                //display all entries
                //loop through the arraylist to show all entries.
                System.out.println();
            }
            case "D" -> {
                //display deposit only entries
            }
            case "P" -> {
                //display payments only(negative entries)
            }
            case "R" -> {
                /*display new screen allowing user to run pre-defined reports or custom search
                 * 1) month to date
                 * 2) previous month
                 * 3) year to date
                 * 4) previous year
                 * 5) search by vendor (prompt user for vendor name and display entries)
                 * 0) back (go back to report page)
                 */
            }
            case "H" -> {
                return;
            }
        }
        System.out.println("------------------------------------------");

    }

}