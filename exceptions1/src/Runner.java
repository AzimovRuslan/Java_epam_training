import Exceptions.NonPositiveNumberException;
import Exceptions.NonPositivePriceException;
import by.gsu.epamlab.Byn;
import by.gsu.epamlab.Purchase;
import by.gsu.epamlab.PurchasesList;

import java.util.ArrayList;
import java.util.Formatter;

public class Runner {
    public static void main(String[] args) throws NonPositivePriceException, NonPositiveNumberException {
        String fileIn = "src/in.csv";
        String fileAddon = "src/addon.csv";

        PurchasesList purchasesList = new PurchasesList(fileIn);
        purchasesList.printList();
        System.out.println();
        PurchasesList additionalPurchasesList = new PurchasesList(fileAddon);
        Purchase lastElementAdditionalPurchasesList = additionalPurchasesList.getPurchases().get(additionalPurchasesList.getPurchases().size() - 1);
        Purchase firstElementAdditionalPurchasesList = additionalPurchasesList.getPurchases().get(0);
        Purchase thirdElementAdditionalPurchasesList = additionalPurchasesList.getPurchases().get(2);
        purchasesList.insertElement(lastElementAdditionalPurchasesList, 0);
        purchasesList.insertElement(firstElementAdditionalPurchasesList, 1000);
        purchasesList.insertElement(thirdElementAdditionalPurchasesList, 2);
        purchasesList.printList();
        System.out.println();

        purchasesList.deleteElement(3);
        purchasesList.deleteElement(5);
        purchasesList.deleteElement(10);

        purchasesList.printList();

        purchasesList.sort();
        purchasesList.printTable();

        Purchase firstPurchase = additionalPurchasesList.findElement(2);
        Purchase p = new Purchase("meat", new Byn(1400), 1);
        int ret = purchasesList.searchIndexElement(p);
        System.out.println(ret);

//        Purchase thirdPurchase = additionalPurchasesList.findElement(3);
//
//        int retPurchase1 = purchasesList.searchIndexElement(thirdPurchase);
//        int retPurchase2 = purchasesList.searchIndexElement(thirdPurchase);
//
//        if (retPurchase1 < 0) {
//            System.out.println(firstPurchase + "not found");
//        } else {
//            System.out.println(purchasesList.getPurchases().get(retPurchase1));
//        }

//        if (retPurchase2 < 0) {
//            System.out.println(thirdPurchase + "not found");
//        } else {
//            System.out.println(purchasesList.getPurchases().get(retPurchase2));
//        }







//        purchasesList.insertElement(new Purchase("fwfe", new Byn(100), 10), 100);
//        purchasesList.deleteElement(102);
//        purchasesList.printList();
//
//        System.out.println(purchasesList.totalCost());
//        purchasesList.sort();
//        purchasesList.printTable();
//        Formatter f = new Formatter();



    }
}
