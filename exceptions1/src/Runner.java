import by.gsu.epamlab.comparator.ComparatorVersion1;
import by.gsu.epamlab.exceptions.NonPositiveNumberException;
import by.gsu.epamlab.exceptions.NonPositivePriceException;
import by.gsu.epamlab.Byn;
import by.gsu.epamlab.Constants;
import by.gsu.epamlab.Purchase;
import by.gsu.epamlab.PurchasesList;

import java.util.Comparator;

public class Runner {

    public static void main(String[] args){
        String fileIn = args[Constants.IN_INDEX];
        String fileAddon = args[Constants.ADDON_INDEX];
        Comparator comparator = PurchasesList.createComparator(args[Constants.COMPARATOR_INDEX]);

        PurchasesList purchasesList = new PurchasesList(fileIn);
        purchasesList.printList();
        System.out.println();
        PurchasesList additionalPurchasesList = new PurchasesList(fileAddon);
        purchasesList.insertElement(additionalPurchasesList.getPurchases().get(additionalPurchasesList.getPurchases().size() - 1), 0);
        purchasesList.insertElement(additionalPurchasesList.getPurchases().get(0), 1000);
        purchasesList.insertElement(additionalPurchasesList.getPurchases().get(2), 2);
        purchasesList.printList();
        System.out.println();

        purchasesList.deleteElement(3);
        purchasesList.deleteElement(5);
        purchasesList.deleteElement(10);

        purchasesList.printList();

        purchasesList.sort(comparator);
        purchasesList.printTable();

        Purchase firstAddonElement = additionalPurchasesList.findElement(1);
        Purchase thirdAddonElement = additionalPurchasesList.findElement(3);
        int retFirstPurchase = purchasesList.searchIndexElement(firstAddonElement, comparator);
        int retThirdPurchase = purchasesList.searchIndexElement(thirdAddonElement, comparator);

        if (retFirstPurchase > 0) {
            System.out.println(firstAddonElement + Constants.ELEMENT_POSITION + retFirstPurchase);
        } else {
            System.out.println(firstAddonElement + Constants.NOT_FOUND_ELEMENT);
        }

        if (retThirdPurchase > 0) {
            System.out.println(thirdAddonElement + Constants.ELEMENT_POSITION + retThirdPurchase);
        } else {
            System.out.println(thirdAddonElement + Constants.NOT_FOUND_ELEMENT);
        }
    }
}
