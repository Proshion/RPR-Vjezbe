package com.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UnesiStaviUListu {
    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Unesite brojeve (ili 'stop' za kraj unosa):");
        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("stop")) {
                break;
            }

            try {
                int number = Integer.parseInt(input);
                lista.add(number);
            } catch (NumberFormatException e) {
                System.out.println("Unesite validan broj ili 'stop' za kraj.");
            }
        }

        if (lista.isEmpty()) {
            System.out.println("Nema unesenih brojeva.");
        } else {
            int min = nadjimin(lista);
            int max = nadjimax(lista);
            double prosjek = suma(lista);
            double SD = standardnadevijacija(lista, prosjek);

            System.out.println("Minimum: " + min);
            System.out.println("Maksimum: " + max);
            System.out.println("Prosjek: " + prosjek);
            System.out.println("Standardna Devijacija: " + SD);
        }

        scanner.close();
    }

    private static int nadjimin(List<Integer> numbers) {
        int min = Integer.MAX_VALUE;
        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }

    private static int nadjimax(List<Integer> numbers) {
        int max = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    private static double suma(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return (double) sum / numbers.size();
    }

    private static double standardnadevijacija(List<Integer> numbers, double mean) {
        double sumOfSquares = 0;
        for (int number : numbers) {
            sumOfSquares += Math.pow(number - mean, 2);
        }
        double variance = sumOfSquares / numbers.size();
        return Math.sqrt(variance);
    }
}

