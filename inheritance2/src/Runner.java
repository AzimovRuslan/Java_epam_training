import by.gsu.epamlab.*;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args){
        final Product product = new Product("Milk", new Byn(180));
        AbstractPurchase[] abstractPurchases = {new PriceDiscountPurchase(product, 9, new Byn(20)),
                new PriceDiscountPurchase(product, 3, new Byn(20)),
                new PercentDiscountPurchase(product, 3, 5.125),
                new PercentDiscountPurchase(product, 6, 6.2),
                new TransportPurchase(product, 10, 200),
                new TransportPurchase(product, 8, 180)};

        Arrays.sort(abstractPurchases);

        for(AbstractPurchase abstractPurchase : abstractPurchases){
            System.out.println(abstractPurchase);
        }
    }
}
