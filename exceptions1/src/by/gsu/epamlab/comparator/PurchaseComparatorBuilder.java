package by.gsu.epamlab.comparator;

import by.gsu.epamlab.Constants;
import by.gsu.epamlab.Purchase;

import java.util.Comparator;

public class PurchaseComparatorBuilder {
    private static Comparator<Purchase> purchaseComparator;
    private PurchaseComparatorBuilder() {
    }
    public static Comparator<Purchase> getPurchaseComparator() {
        return purchaseComparator;
    }

    public static Comparator<Purchase> buildPurchaseComparator(String comparatorName) {
        String fullName = Constants.COMPARATOR_PATH + comparatorName;
        Comparator<Purchase> comparator = new PurchaseComparatorV1();
        try {
            Class classComparator = Class.forName(fullName);
            comparator = (Comparator<Purchase>) classComparator.newInstance();
        } catch (Exception e) {
            purchaseComparator = new PurchaseComparatorV1();
        }
        return comparator;
    }



}
