import java.util.Scanner;
public class Main{
    public static double calculateSinus(double number) {
        return Math.sin(number);
    }

    public static long calculateFactorial(int number) {
        if (number < 0) {
            return -1; // Invalid input
        }
        long factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Molimo unesite točno jedan broj.");
            return;
        }

        try {
            double inputNumber = Double.parseDouble(args[0]);
            double sinusResult = calculateSinus(inputNumber);
            System.out.println("Sinus od " + inputNumber + " je: " + sinusResult);

            int intInputNumber = (int) inputNumber;
            long factorialResult = calculateFactorial(intInputNumber);
            if (factorialResult == -1) {
                System.out.println("Faktorijel se ne može izračunati za negativne brojeve.");
            } else {
                System.out.println("Faktorijel od " + intInputNumber + " je: " + factorialResult);
            }
        } catch (NumberFormatException e) {
            System.out.println("Uneseni argument nije valjani broj.");
        }
    }
}