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
            final int PURCHASES_NUMBER = 6;
            Purchase[] purchases = new Purchase[PURCHASES_NUMBER];
            Purchase maxPurchase = new Purchase();
            boolean areEqual = true;

            for (int i = 0; i < purchases.length; i++) {
                purchases[i] = PurchasesFactory.getPurchaseFromFactory(sc);
                System.out.println(purchases[i]);

                if (maxPurchase.getCost().compareTo(purchases[i].getCost()) < 0) {
                    maxPurchase = purchases[i];
                }

                Purchase firstPurchase = purchases[0];

                if (!firstPurchase.equals(purchases[i])) {
                    areEqual = false;
                }
            }
            System.out.println("Max cost purchase = " + maxPurchase);

            if (areEqual) {
                System.out.println("all purchases are equal");
            } else {
                System.out.println("not all purchases are equal");
            }

            
        } catch (FileNotFoundException e) {
            System.err.println("File not fount");
        }
    }
}


