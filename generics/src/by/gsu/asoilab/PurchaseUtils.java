package by.gsu.asoilab;

import by.gsu.asoilab.interfaces.Priceable;

public class PurchaseUtils<T extends Priceable, E extends Number> {
    private Purchase<T, E> purchase;

    public PurchaseUtils(Purchase<T, E> purchase) {
        this.purchase = purchase;
    }

    public Purchase<T, E> getPurchase() {
        return purchase;
    }

    public void printPurchase() {
        System.out.println(purchase);
    }

    public void printCost() {
        System.out.println(Constants.COST + purchase.getCost() + Constants.BYN);
    }

    public void printCostDiff(Purchase<? extends Priceable, ? extends Number> p) {
        int diff = purchase.getCost().getKopecks() - p.getCost().getKopecks();
        String diffStr = "";
        if (diff > 0) {
            diffStr = Constants.PLUS + Constants.DIFF;
        } else if (diff < 0) {
            diffStr = Constants.MINUS + Constants.DIFF;
            diff = Math.abs(diff);
        } else {
            diffStr = Constants.DIFF;
        }
        System.out.println(diffStr + new Byn(diff) + Constants.BYN);
    }

    public void printSameCost(Purchase<? extends Priceable, ? extends Number>... purchases) {
        boolean flag = false;
        for (Purchase<? extends Priceable, ? extends Number> p : purchases) {
            if (purchase.getCost().compareTo(p.getCost()) == 0) {
                flag = true;
                break;
            }
        }
        System.out.println(flag ? Constants.HAVE_PURCHASE : Constants.DONT_HAVE_PURCHASE);
    }
}