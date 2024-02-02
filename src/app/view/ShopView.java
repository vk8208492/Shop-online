package app.view;

import java.util.Locale;
import java.util.Scanner;

public class ShopView {

    private final Scanner scanner = new Scanner(System.in);

    public String[] getData() {
        scanner.useLocale(Locale.ENGLISH);
        System.out.println("Enter buyer productName:");
        String productName = scanner.nextLine().trim();
        System.out.println("Enter buyer clientPhone:");
        String clientPhone = scanner.nextLine().trim();
        System.out.print("Enter product count, pcs.: ");
        String count = scanner.nextLine().trim();
        System.out.print("Enter product price, EUR: ");
        String price = scanner.nextLine().trim();
        System.out.println("pickup yes or no");
        String pickup = scanner.nextLine().trim();
        scanner.close();
        return new String[]{productName, clientPhone, count, price,pickup};
    }
    public void getOutput(String output) {
        System.out.println(output);
    }
}

