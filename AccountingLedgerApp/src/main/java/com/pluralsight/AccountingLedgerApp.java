package com.pluralsight;
import java.io.*;
import java.util.ArrayList;

public class AccountingLedgerApp {

    public final static File fileName = new File("Transactions.csv");
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
                    HomeFunctions.addDeposit();
                } else if (selection.equalsIgnoreCase("P")) {
                    HomeFunctions.makePayment();
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
        } while (true);
    }

    public static void ledgerScreen() {

         /*This is my ledger screen class. Here you can review all entries,
     deposit only entries, payment only entries, and ledger reports.*/


        System.out.println("Welcome to your Ledger Screen! ");
        System.out.println("------------------------------------------");
        System.out.println("Please make a selection: ");
        System.out.println(" (A) All entries");
        System.out.println(" (D) Deposits ");
        System.out.println(" (P) Payments ");
        System.out.println(" (R) Reports ");
        System.out.println(" (H) Home ");
        System.out.print("Enter (A), (D), (P), (R) or (H): ");
        String selection = Console.PromptForString();

        System.out.println("------------------------------------------");

        if (selection.equalsIgnoreCase("A")) {
            LedgerFunctions.allEntries();
        } else if (selection.equalsIgnoreCase("D")) {
            LedgerFunctions.depositsOnly();
        } else if (selection.equalsIgnoreCase("P")) {
            LedgerFunctions.paymentsOnly();
        } else if (selection.equalsIgnoreCase("R")) {
            reports();
        } else if (selection.equalsIgnoreCase("H")) {
            homeScreen();
        }
        System.out.println("------------------------------------------");

    }

    public static void reports() {
        /*display new screen allowing user to run pre-defined reports or custom search
         * 1) month to date
         * 2) previous month
         * 3) year to date
         * 4) previous year
         * 5) search by vendor (prompt user for vendor name and display entries)
         * 0) back (go back to report page)
         */
        System.out.println("Welcome to your reports screen");
        System.out.println("Please select how you'd like to view your transactions: ");
        System.out.println(" 1) Month to Date ");
        System.out.println(" 2) Previous Month");
        System.out.println(" 3) Year to Date");
        System.out.println(" 4) Previous Year");
        System.out.println(" 5) Search by vendor");
        System.out.println(" 0) Go back");
        int selection = Console.PromptForInt();

        if(selection == 1){
            ReportsFunctions.monthToDate();
        }
        if(selection == 2){
            ReportsFunctions.previousMonth();
        }
        if(selection == 3){
            ReportsFunctions.yearToDate();
        }
        if(selection == 4){
            ReportsFunctions.previousYear();
        }
        if(selection == 5){
            ReportsFunctions.searchByVendor();
        }
        if(selection == 0){
            reports();
        }


    }
}
