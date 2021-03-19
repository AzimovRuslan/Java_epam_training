import by.gsu.epamlab.Purchase;
import by.gsu.epamlab.PurchasesFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new FileReader("src/in.txt"))) {
            sc.useLocale(Locale.ENGLISH);

            Purchase[] purchases = new Purchase[6];
            Purchase maxPurchase = new Purchase();
            boolean flag = true;

            for (int i = 0; i < purchases.length; i++) {
                purchases[i] = PurchasesFactory.getPurchaseFromFactory(sc);
                System.out.println(purchases[i]);

                if (maxPurchase.getCost().compareTo(purchases[i].getCost()) < 0) {
                    maxPurchase = purchases[i];
                }

                Purchase firstPurchase = purchases[0];

                if (!firstPurchase.equals(purchases[i])) {
                    flag = false;
                }
            }
            System.out.println("Max cost purchase = " + maxPurchase);

            if (flag) {
                System.out.println("all purchases are equal");
            } else {
                System.out.println("not all purchases are equal");
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not fount");
        }
    }
}

