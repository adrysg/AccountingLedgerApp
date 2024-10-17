package com.pluralsight;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class LedgerFunctions {
    public final static File fileName = new File("Transactions.csv");
    public static ArrayList<Transaction> ledger = BuffReader.getTransaction();


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

        } AccountingLedgerApp.ledgerScreen();
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

        } AccountingLedgerApp.ledgerScreen();
    }

}
