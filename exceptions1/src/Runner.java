import by.gsu.epamlab.Constants;
import by.gsu.epamlab.Purchase;
import by.gsu.epamlab.PurchasesList;
import by.gsu.epamlab.comparator.PurchaseComparatorBuilder;

import java.util.Comparator;

public class Runner {

    public static void main(String[] args){
        String fileIn = args[Constants.IN_INDEX];
        String fileAddon = args[Constants.ADDON_INDEX];
        Comparator comparator = PurchaseComparatorBuilder.buildPurchaseComparator(args[Constants.COMPARATOR_INDEX]);

        PurchasesList purchasesList = new PurchasesList(fileIn);

        printList(purchasesList);

        PurchasesList additionalPurchasesList = new PurchasesList(fileAddon);

        purchasesList.insertElement(findAddonElement(additionalPurchasesList, additionalPurchasesList.getPurchases().size() - 1), 0);

        purchasesList.insertElement(findAddonElement(additionalPurchasesList, 0), 1000);

        purchasesList.insertElement(findAddonElement(additionalPurchasesList, 2), 2);

        deleteElement(purchasesList, 3);
        deleteElement(purchasesList, 10);
        deleteElement(purchasesList, -5);

        printList(purchasesList);

        purchasesList.sort(comparator);

        printTable(purchasesList);

        Purchase firstAddonElement = additionalPurchasesList.findElement(1);
        Purchase thirdAddonElement = additionalPurchasesList.findElement(3);
        int retFirstPurchase = purchasesList.searchIndexElement(firstAddonElement, comparator);
        int retThirdPurchase = purchasesList.searchIndexElement(thirdAddonElement, comparator);
        findElement(firstAddonElement, retFirstPurchase);
        findElement(thirdAddonElement, retThirdPurchase);
    }

    private static void printList(PurchasesList purchasesList) {
        purchasesList.printList();
    }

    private static void deleteElement(PurchasesList purchasesList, int index) {
        purchasesList.deleteElement(index);
    }

    private static Purchase findAddonElement(PurchasesList additionalPurchasesList, int index) {
        return additionalPurchasesList.getPurchases().get(index);
    }

    private static void printTable(PurchasesList purchasesList) {
        purchasesList.printTable();
    }

    private static void findElement(Purchase addonElement, int retPurchase) {
        if (retPurchase > 0) {
            System.out.println(addonElement + Constants.ELEMENT_POSITION + retPurchase);
        } else {
            System.out.println(addonElement + Constants.NOT_FOUND_ELEMENT);
        }
    }
}
