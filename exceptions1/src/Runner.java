import Exceptions.NonPositiveNumberException;
import Exceptions.NonPositivePriceException;
import by.gsu.epamlab.Byn;
import by.gsu.epamlab.Purchase;
import by.gsu.epamlab.PurchasesList;

public class Runner {
    public static void main(String[] args) throws NonPositivePriceException, NonPositiveNumberException {
        PurchasesList purchasesList = new PurchasesList("src/in.csv");

        purchasesList.insertElement(new Purchase("fwfe", new Byn(100), 10), 100);
        purchasesList.deleteElement(102);
        purchasesList.printList();

        System.out.println(purchasesList.totalCost());
        purchasesList.printTable();
//        Formatter f = new Formatter();

    }
}
