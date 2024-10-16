package com.pluralsight;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Pattern;


public class Main {

    public final static File fileName = new File("Transactions.csv");
    public static ArrayList<Transaction> ledger = getTransaction();
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args)  {

//Create a home screen
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
//Create a ledger screen
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
            reports();
        } else if (selection.equalsIgnoreCase("H")) {
            return;
        }
        System.out.println("------------------------------------------");

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

        Transaction t = new Transaction(date, time, description,vendorName, depositAmount);
        ledger.add(t);
        saveTransaction();
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
        ledger.add(t);
        saveTransaction();
        System.out.println("Your transaction has been successfully saved! ");

    }
    
    private static void reports() {
        /*display new screen allowing user to run pre-defined reports or custom search
         * 1) month to date
         * 2) previous month
         * 3) year to date
         * 4) previous year
         * 5) search by vendor (prompt user for vendor name and display entries)
         * 0) back (go back to report page)
         */






    }

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

    private static void depositsOnly() {
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

        } ledgerScreen();
    }

    private static void paymentsOnly() {
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

        } ledgerScreen();
    }

    public static ArrayList<Transaction> getTransaction() {
        ArrayList<Transaction> ledger = new ArrayList<>();
        // this method loads product objects into Transactions
        // and its details are not shown

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            String input;
            while ((input = br.readLine()) != null) {
                String[] tokens = input.split(Pattern.quote("|"));
                LocalDate date = LocalDate.parse(tokens[0]);
                LocalTime time = LocalTime.parse(tokens[1]);
                String description = tokens[2];
                String vendor = tokens[3];
                double amount = Double.parseDouble(tokens[4]);
                Transaction t = new Transaction(date, time, description, vendor, amount);
                ledger.add(t);
            }
            br.close();

        } catch (Exception e) {
            System.out.println("ERROR!!");
            e.printStackTrace();
        }
        return ledger;
    }

    public static void saveTransaction () {

            try {

                FileWriter fw = new FileWriter(fileName, true);

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
