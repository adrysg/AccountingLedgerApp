package com.pluralsight;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class ReportsScreen {

    /*this is my reports screen, it allows the user to search for their transactions
    based on certain date ranges. The functions for this class are also below.
     */

    public final static File fileName = new File("Transactions.csv");
    public static void reports() {

        System.out.println("Welcome to your reports screen");
        System.out.println("Please select how you'd like to view your transactions: ");
        System.out.println(" 1) Month to Date ");
        System.out.println(" 2) Previous Month");
        System.out.println(" 3) Year to Date");
        System.out.println(" 4) Previous Year");
        System.out.println(" 5) Search by vendor");
        System.out.println(" 0) Go back");
        System.out.print("Enter selection: ");
        int selection = Console.PromptForInt();


        if (selection == 1) {
            monthToDate();
        }
        if (selection == 2) {
            previousMonth();
        }
        if (selection == 3) {
            yearToDate();
        }                                              //mapping each selection to it's corresponding methods.
        if (selection == 4) {
            previousYear();
        }
        if (selection == 5) {
            searchByVendor();
        }
        if (selection == 0) {
            reports();
        }
    }

// this method shows entries for the beginning of the month up to the current date
    public static void monthToDate() {

        System.out.print("Below are your Month to Date transactions: ");
        System.out.println("------------------------------------------");

        //here I use the buffered reader to read through the file to find users selected entries.

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            LocalDate date = LocalDate.now();
            DateTimeFormatter formatedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            while ((line = br.readLine()) != null) {

                String[] tokens = line.split(Pattern.quote("|"));


                if (tokens.length > 4) {   //this line ensures the tokens array has more than 4 values

                    LocalDate transactionsDate = LocalDate.parse(tokens[0].trim(), formatedDate);
                    if(transactionsDate.getMonth() == date.getMonth()
                            || transactionsDate.getYear() == date.getYear())
                    {
                         System.out.println(line);
                    }
                }
            }
            System.out.println();

            br.close();
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }

// this method shows entries for the previous month
    public static void previousMonth () {

        System.out.print("Below are previous months transactions: ");
        System.out.println("------------------------------------------");
            try {
                BufferedReader br = new BufferedReader(new FileReader(fileName));
                String line;
                LocalDate date = LocalDate.now();
                LocalDate previousMonth = date.minusMonths(1);
                DateTimeFormatter formatedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                while ((line = br.readLine()) != null) {

                    String[] tokens = line.split(Pattern.quote("|"));

                    if (tokens.length > 4) {
                        LocalDate transactionsDate = LocalDate.parse(tokens[0].trim(), formatedDate);
                        if(transactionsDate.getMonth() == previousMonth.getMonth()
                                || transactionsDate.getYear() == previousMonth.getYear())
                        {
                            System.out.println(line);
                        }
                    }
                }
                System.out.println();

                br.close();
            } catch (Exception e) {
                System.out.println("Error!");
            }
        }

// this method looks for the entries for this year up to the current date.
    public static void yearToDate () {

        System.out.print("Below are your Year to Date Transactions: ");
        System.out.println("------------------------------------------");
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = br.readLine()) != null) {
                LocalDate date = LocalDate.now();
                int currentYear = date.getYear();
                DateTimeFormatter formatedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                String[] tokens = line.split(Pattern.quote("|"));

                if (tokens.length > 4) {
                    LocalDate transactionsDate = LocalDate.parse(tokens[0].trim(), formatedDate);
                    if(transactionsDate.getYear() == currentYear)
                    {
                        System.out.println(line);
                    }
                }
            }
            System.out.println();

            br.close();
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }

// this method searches for entries from the previous year on the file.
    public static void previousYear () {
        System.out.print("Below are transactions for last year: ");
        System.out.println("------------------------------------------");
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            LocalDate date = LocalDate.now();
            int previousYear = date.getYear() - 1;

            while ((line = br.readLine()) != null) {

                DateTimeFormatter formatedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                String[] tokens = line.split(Pattern.quote("|"));

                if (tokens.length > 4) {
                    LocalDate transactionsDate = LocalDate.parse(tokens[0].trim(), formatedDate);
                    if(transactionsDate.getYear() == previousYear)
                    {
                        System.out.println(line);
                    }
                }
            }
            System.out.println();

            br.close();
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }

// this method allows the user to search by vendor upon selection.
    public static void searchByVendor () {
        System.out.print("Please enter the vendor's name: ");
        String searchedVendor = Console.PromptForString().trim();
        System.out.println("------------------------------------------");

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = br.readLine()) != null) {

                String[] tokens = line.split(Pattern.quote("|"));

                if (tokens.length > 4) {
                    String vendor = tokens[3].trim();
                    if(searchedVendor.equalsIgnoreCase(vendor))
                    {
                        System.out.println(line);
                    }
                }
            }
            System.out.println();

            br.close();
        } catch (Exception e) {
            System.out.println("Error!");
        }
        }

}

