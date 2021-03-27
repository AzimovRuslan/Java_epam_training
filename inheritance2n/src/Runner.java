import by.gsu.epamlab.AbstractPurchase;
import by.gsu.epamlab.Byn;
import by.gsu.epamlab.Product;
import by.gsu.epamlab.PercentDiscountPurchase;
import by.gsu.epamlab.PriceDiscountPurchase;
import by.gsu.epamlab.TransportPurchase;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args){
        final Product product = new Product("Milk", new Byn(180));

        AbstractPurchase[] purchases = {
                new PriceDiscountPurchase(product, 3, new Byn(20)),
                new PercentDiscountPurchase(product, 3, 5.125),
                new PercentDiscountPurchase(product, 6, 6.2),
                new TransportPurchase(product, 2, new Byn(140)),
                new TransportPurchase(product, 8, new Byn(100)),
                new PriceDiscountPurchase(product, 9, new Byn(20))
        };

        printArray(purchases);

        Arrays.sort(purchases);

        printArray(purchases);

        System.out.println("Minimum cost = " + purchases[purchases.length - 1].getCost());

        AbstractPurchase key = new TransportPurchase(product, 2, new Byn(140));
        int pos = Arrays.binarySearch(purchases, key);
        if (pos >= 0) {
            System.out.println("Purchase with cost equal to 5.00 BYN = " + purchases[pos]);
        } else {
            System.out.println("Purchase with cost equal to 5.00 BYN not found");
        }
    }

    private static void printArray(AbstractPurchase[] purchases) {
        for(AbstractPurchase purchase : purchases){
            System.out.println(purchase);
        }
    }
}
