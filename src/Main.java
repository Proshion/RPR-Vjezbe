import java.util.Scanner;
public class Main {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        System.out.println("Unesite prvi cijeli broj: ");
        int prviBroj = input.nextInt();

        Scanner input2 = new Scanner(System.in);
        System.out.println("Unesite drugi cijeli broj: ");
        int drugiBroj = input2.nextInt();

        System.out.println("Unijeli ste prvi broj: " + prviBroj);
        System.out.println("Unijeli ste drugi broj: " + drugiBroj);

    }
}
