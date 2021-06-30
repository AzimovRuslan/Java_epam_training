package by.gsu.epamlab;

import Exceptions.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class PurchasesList {
    private String filename;
    private ArrayList<Purchase> purchases;
    private String[] str;

    public PurchasesList() {
        this(null);
    }

    public ArrayList<Purchase> getPurchases() {
        return purchases;
    }

    public PurchasesList(String filename) {
        this.filename = filename;
        try (Scanner sc = new Scanner(new FileReader(filename))) {
            purchases = new ArrayList<>();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                try {
                    purchases.add(PurchasesFactory.getPurchase(line));
                } catch (NullPointerException e) {
                    System.err.println(e);
                } catch (WrongAmountArgumentsException | IncorrectNumberException | NonPositiveNumberException | EmptyArgumentException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not fount");
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
        try {
            purchases.remove(index);
        } catch (IndexOutOfBoundsException e) {
            System.err.println(e);
        }
    }

    public Byn totalCost() {
        Byn totalCost = new Byn(0);
        for (Purchase purchase : purchases) {
            totalCost = totalCost.add(purchase.getCost());
        }
        return totalCost;
    }

    public void printTable() {
        Formatter f = new Formatter();
        f.format("Name     Price     Number     Discount     Cost");

        for (int i = 0; i < purchases.size(); i++) {
            f.format("\n" + purchases.get(i).table());
        }
        System.out.println(f);
    }
}
