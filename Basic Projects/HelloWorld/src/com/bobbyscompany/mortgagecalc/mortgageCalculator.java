package com.bobbyscompany.mortgagecalc;

import java.text.NumberFormat;
import java.util.Scanner;

public class mortgageCalculator {
//   Old Unconsolidated Code---> public static void main(String[] args) {
//        final byte MONTHS_IN_YEAR = 12;
//        final byte PERCENT = 100;
//        int principal;
//        float annualInterest;
//        byte years;
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            System.out.println("Principal: ");
//            principal = scanner.nextInt();
//            if (principal >= 1000 && principal <= 1000000)
//                break;
//             else
//                System.out.println("Enter a number between 1,000 and 1,000,000");
//        }
//        while (true) {
//            System.out.println("Annual Interest Rate: ");
//            annualInterest = scanner.nextFloat();
//            if (annualInterest > 0 && annualInterest < 31)
//                break;
//            else
//                System.out.println("Enter a value greater than 0 and less than or equal to 30");
//        }
//        while (true) {
//            System.out.println("Period (Years): ");
//            years = scanner.nextByte();
//            if (years > 0 && years < 31)
//                break;
//            else
//                System.out.println("Enter a value between 1 and 30");
//        }
//        int numberOfPayments = years * MONTHS_IN_YEAR;
//        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
//        double mortgage = principal
//                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
//                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
//
//        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
//        System.out.println("Mortgage: " + mortgageFormatted);
//    }  <--- Old Unconsolidated Code
final static byte MONTHS_IN_YEAR = 12;
final static byte PERCENT = 100;
    public static void main(String[] args) {
        int principal = (int) readNumber("Principal: ", 1000, 1000000);
        float annualInterest = (float) readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) readNumber("Period (Years): ", 1, 30);
        printMortgage(principal, annualInterest, years);
        printPaymentSchedule(principal, annualInterest, years);
    }

    private static void printMortgage(int principal, float annualInterest, byte years) {
        double mortgage = calculateMortgage(principal, annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: ");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }

    private static void printPaymentSchedule(int principal, float annualInterest, byte years) {
        System.out.println();
        System.out.println("Payment Schedule: ");
        for (short month = 1; month <= years * MONTHS_IN_YEAR; month++) {
            double remainingBalance = calculateBalance(principal, annualInterest, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(remainingBalance));
        }
    }
    public static double readNumber(String prompt, int min, int max){
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.println(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a number between " + min + " and " + max);
        }
        return value;
    }
    public static double calculateMortgage(
            int principal,
            float annualInterest,
            byte years
    ){
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);
        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        return mortgage;
    }
    public static double calculateBalance(
            int principal,
            float annualInterest,
            byte years,
            short numberOfPaymentsMade
    ){
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);
        double remainingBalance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments)
                - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return remainingBalance;
    }
}
