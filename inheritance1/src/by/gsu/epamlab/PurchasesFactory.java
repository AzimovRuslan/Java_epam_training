package by.gsu.epamlab;

import java.util.Scanner;

public class PurchasesFactory {
    private enum PurchaseKind{
        GENERAL_PURCHASE,
        PRICE_PURCHASE_DISCOUNT,
        PERCENT_DISCOUNT_PURCHASE
    }

    public static Purchase getPurchaseFromFactory(Scanner sc){
        String id = sc.next();
        PurchaseKind kind = PurchaseKind.valueOf(id);
        switch (kind){
            case GENERAL_PURCHASE:
                return new Purchase(sc);
            case PRICE_PURCHASE_DISCOUNT:
                return new PriceDiscountPurchase(sc);
            case PERCENT_DISCOUNT_PURCHASE:
                return new PercentDiscountPurchase(sc);
            default :
                throw new IllegalArgumentException();
        }
    }
}
