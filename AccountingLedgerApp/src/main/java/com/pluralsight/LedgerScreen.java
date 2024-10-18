package com.pluralsight;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Pattern;

public class LedgerScreen {
    public final static File fileName = new File("Transactions.csv");

    public static void ledgerScreen() {

         /*This is my ledger screen class. Here the user can review all entries,
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
            allEntries();
        } else if (selection.equalsIgnoreCase("D")) {
            depositsOnly();
        } else if (selection.equalsIgnoreCase("P")) {
            paymentsOnly();
        } else if (selection.equalsIgnoreCase("R")) {
            ReportsScreen.reports();
        } else if (selection.equalsIgnoreCase("H")) {
            Main.homeScreen();
        }
        System.out.println("------------------------------------------");

    }

    //these are the methods for each selection being called into action.

    public static void allEntries() {
        //display all entries
        //loop through the arraylist to show all entries.
        System.out.println("All entries are listed below:\n ");

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }

    public static void depositsOnly() {
        System.out.println("Deposit Only Entries:\n ");

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(Pattern.quote("|"));

                if (tokens.length > 4) {
                    double amount = Double.parseDouble(tokens[4].trim()); {
                        if (amount > 0) {
                            System.out.println(line);

                        }
                    }
                }
            } System.out.println();

            br.close();
        } catch (Exception e) {
            System.out.println("Error!");

        } LedgerScreen.ledgerScreen();
    }

    public static void paymentsOnly() {
        System.out.println("Payment Only Entries:\n ");
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(Pattern.quote("|"));

                if (tokens.length > 4) {
                    double amount = Double.parseDouble(tokens[4].trim()); {
                        if (amount < 0) {
                            System.out.println(line);

                        }
                    }
                }
            } System.out.println();

            br.close();
        } catch (Exception e) {
            System.out.println("Error!");

        } LedgerScreen.ledgerScreen();
    }

}
