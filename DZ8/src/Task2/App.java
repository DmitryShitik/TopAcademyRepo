package Task2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            findExceptionNumber(scanner.nextInt());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void findExceptionNumber(int value) throws Exception {
        if (value < 0) throw new Exception("Number < 0");
        else if (value > 100) throw new RuntimeException("Number > 100");
    }
}
