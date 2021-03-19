import by.gsu.epamlab.Byn;
import by.gsu.epamlab.Purchase;
import by.gsu.epamlab.PurchasesFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new FileReader("src/in.txt"))) {

            Purchase[] purchases = new Purchase[6];
            Purchase maxPurchase = new Purchase();

            for(int i = 0; i < purchases.length; i++) {
                purchases[i] = PurchasesFactory.getPurchaseFromFactory(sc);
                System.out.println(purchases[i]);

                if(maxPurchase.getCost() < purchases[i].getCost()){
                    maxPurchase = purchases[i];
                }

                Purchase firstPurchase = purchases[0];
                System.out.println(purchases[i].equals(firstPurchase));
            }

            System.out.println("Max cost purchase = " + maxPurchase);
        } catch (FileNotFoundException e) {
            System.err.println("File not fount");
        }
    }
}
