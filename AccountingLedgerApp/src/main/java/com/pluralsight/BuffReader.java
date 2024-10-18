package com.pluralsight;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class BuffReader {

    /*This is my reader class. The buffered reader reads through the transactions.csv file.
        These lines of code below represent a tokens array which takes each value in the transactions.csv
        file and adds it to the array. the values containing numbers are parsed into a String to represent
        either the date or amount.*/

    public final static File fileName = new File("Transactions.csv");


    public static ArrayList<Transaction> getTransaction() {
        ArrayList<Transaction> ledger = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            br.readLine();
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
            System.out.println("Error!");
        }
        return ledger;
    }

}


