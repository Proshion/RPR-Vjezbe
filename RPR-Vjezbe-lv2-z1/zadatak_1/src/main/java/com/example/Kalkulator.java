package com.example;

public class Kalkulator {
    public static double calculateSin(double number) {
        return Math.sin(number);
    }

    public static long calculateFactorial(int number) {
        if (number == 0 || number == 1) {
            return 1;
        } else {
            return number * calculateFactorial(number - 1);
        }
    }
}
