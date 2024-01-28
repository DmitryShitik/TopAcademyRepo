package Task1;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        try {
            findDiv(value);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void findDiv(int value) throws Exception {
        int[] dividesNum = new int[10];
        Random rnd = new Random();
        for (int i = 0; i < dividesNum.length; i++) {
            dividesNum[i] = rnd.nextInt(-10, 11);
            if (dividesNum[i] == 0) throw new Exception("Divide by zero incorrect");
            double result = (double) value / dividesNum[i];
            System.out.printf("%d / %d = %.2f\n", value, dividesNum[i], result);
        }
    }
}