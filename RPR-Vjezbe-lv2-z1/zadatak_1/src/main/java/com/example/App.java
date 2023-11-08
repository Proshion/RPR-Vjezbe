package com.example;

import java.util.Scanner;

public class App
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Unesite broj: ");
            int broj = scanner.nextInt();
            double sinResult = Kalkulator.calculateSin(broj);
            long factorialResult = Kalkulator.calculateFactorial((int) broj);

            System.out.println("Sinus broja " + broj + " je: " + sinResult);
            System.out.println("Faktorijel broja " + (int) broj + " je: " + factorialResult);

            scanner.close();

    }
    }

