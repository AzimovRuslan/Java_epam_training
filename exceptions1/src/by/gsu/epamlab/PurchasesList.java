package by.gsu.epamlab;

import by.gsu.epamlab.exceptions.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class PurchasesList {
    private List<Purchase> purchases;

    public PurchasesList() {
        purchases = new ArrayList<>();
    }

    public List<Purchase> getPurchases() {
        return new ArrayList<>(purchases);
    }

    public PurchasesList(String filename) {
        try (Scanner sc = new Scanner(new FileReader(filename))) {
            purchases = new ArrayList<>();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                try {
                    purchases.add(PurchasesFactory.getPurchase(line));
                } catch (NullPointerException | NonPositiveArgumentException | CsvLineException e) {
                    System.err.println(line + Constants.ARROW + e);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(Constants.FILE_NOT_FOUND);
        }
    }

    public void printList() {
        for (Purchase purchase : purchases) {
            System.out.println(purchase);
        }
    }

    public void insertElement(Purchase purchase, int index) {
        try {
            purchases.add(index, purchase);
        } catch (IndexOutOfBoundsException e) {
            purchases.add(purchases.size(), purchase);
        }
    }

    public void deleteElement(int index) {
        if (index >= 0 && index < purchases.size()) {
            purchases.remove(index);
        }
    }

    public Byn getTotalCost() {
        Byn totalCost = new Byn(0);
        for (Purchase purchase : purchases) {
            totalCost = totalCost.add(purchase.getCost());
        }
        return totalCost;
    }

    public void printTable() {
        Formatter f = new Formatter();
        String tableFormat = "%1$15s %2$15s %3$15s %4$17s %5$13s%n";
        f.format(tableFormat, "Name", "Price", "Number", "Discount", "Cost");
        for (Purchase purchase : purchases) {
            String[] line = formatLine(purchase);
            f.format(tableFormat, line[0], line[1], line[2], line[3], line[4]);
        }
        f.format(tableFormat, "Total cost", "", "", "", getTotalCost());
        System.out.println(f);
    }

    private static String[] formatLine(Purchase purchase) {
        String[] str = purchase.toString().split(";");
        if (str.length == 4) {
            str = Arrays.copyOf(str, str.length + 1);
            str[4] = str[3];
            str[3] = "-";
        }
        return str;
    }

    public void sort(Comparator<Purchase> comparator) {
        purchases.sort(comparator);
    }

    public Purchase findElement(int index) {
        return purchases.get(index);
    }

    public int searchIndexElement(Purchase purchase, Comparator<Purchase> comparator) {
        return Collections.binarySearch(purchases, purchase, comparator);
    }
}
