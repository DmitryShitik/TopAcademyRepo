import java.util.Scanner;

public class Main {
    static int statusProgram = 0;
    static Scanner scanner = new Scanner(System.in);
    static Storage storage = new Storage();

    public static void main(String[] args) {

        while (true) {
            switch (statusProgram) {
                case -1:
                    break;
                case 0:
                    showMenu();
                    break;
                case 1:
                    addNewProducts();
                    break;
                case 2:
                    showProviders();
                    break;
                case 3:
                    showProducts();
                    break;
                case 4:
                    findAddressProduct();
                    break;
            }
            if (statusProgram == -1) break;
        }

    }

    public static void showMenu() {
        System.out.println("****Storage invoice****\n" +
                "Chose operation:\n" +
                "1 - add new invoice\n" +
                "2 - show providers\n" +
                "3 - show products\n" +
                "4 - find address product\n" +
                "-1 - close program\n");

        int chose = scanner.nextInt();
        if (chose == -1) statusProgram = -1;
        else if (chose == 1) statusProgram = 1;
        else if (chose == 2) statusProgram = 2;
        else if (chose == 3) statusProgram = 3;
        else if (chose == 4) statusProgram = 4;
        else System.out.println("Incorrect operation... Pleas chose again!");
    }

    public static void addNewProducts() {
        System.out.println("Write provider name");
        String provider = scanner.next();
        System.out.println("Write product name");
        String product = scanner.next();
        try {
            storage.newProduct(provider, product);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        statusProgram = 0;
    }

    public static void showProviders() {
        storage.showProviders();
        statusProgram = 0;
    }

    public static void showProducts() {
        storage.showProducts();
        statusProgram = 0;
    }

    public static void findAddressProduct() {
        System.out.println("Write find product");
        String s = scanner.next();
        System.out.println(storage.findAddressProduct(s));
        statusProgram = 0;
    }
}