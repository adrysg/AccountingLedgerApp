package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.regex.Pattern;
import static com.pluralsight.BuffReader.fileName;

public class ReportsScreen {

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
            monthToDate();
        }
        if(selection == 2){
            previousMonth();
        }
        if(selection == 3){
            yearToDate();
        }
        if(selection == 4){
            previousYear();
        }
        if(selection == 5){
            searchByVendor();
        }
        if(selection == 0){
            reports();
        }


    }

    public static void monthToDate(){
        System.out.println("Below are your Month to Date transactions: \n");
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(Pattern.quote("|"));

                if (tokens.length > 4) {
                    LocalDate date = LocalDate.parse(tokens[0]); {
                        if (date.isBefore(LocalDate.now())) {
                            System.out.println(line);

                        }
                    }
                }
            } System.out.println();

            br.close();
        } catch (Exception e) {
            System.out.println("Error!");

        }

    }


    public static void previousMonth(){

    }

    public static void yearToDate(){

    }

    public static void previousYear(){

    }

    public static void searchByVendor(){

    }

}
