package com.pluralsight;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class BuffReader {

    public final static File fileName = new File("Transactions.csv");
    public static ArrayList<Transaction> ledger = getTransaction();

    public static ArrayList<Transaction> getTransaction() {
        ArrayList<Transaction> ledger = new ArrayList<>();

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
            System.out.println("Error!");
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
