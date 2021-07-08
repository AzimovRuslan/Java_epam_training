package by.gsu.asoilab;

public class PurchaseUtils {
    private Purchase purchase;

    public PurchaseUtils(Purchase purchase) {
        this.purchase = purchase;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void printPurchase() {
        System.out.println(purchase);
    }

    public void printCost() {
        System.out.println("cost = " + purchase.getCost() + " BYN");
    }

    public void printCostDiff(Purchase p) {
//        int diff = purchase.getCost().getKopecks() - p.getCost().getKopecks();
//        if (diff > 0) {
//            System.out.println("+ diff = " + new Byn(diff) + " BYN");
//        } else if (diff < 0) {
//            System.out.println("- diff = " + new Byn(Math.abs(diff)) + " BYN");
//        } else {
//            System.out.println("  diff = " + new Byn(diff) + " BYN");
//        }
        Byn greaterCost;
        Byn lesserCost;
        Byn costDiff;
        if (purchase.getCost().getKopecks() > p.getCost().getKopecks()) {
            greaterCost = purchase.getCost();
            lesserCost = p.getCost();
            costDiff = greaterCost.sub(lesserCost);
            System.out.println("+ diff = " + costDiff + " BYN");
        } else if (purchase.getCost().getKopecks() < p.getCost().getKopecks()) {
            greaterCost = p.getCost();
            lesserCost = purchase.getCost();
            costDiff = greaterCost.sub(lesserCost);
            System.out.println("- diff = " + costDiff + " BYN");
        } else {
            System.out.println("diff = 0 BYN");
        }
    }

    public void printSameCost(Purchase[] purchases) {
        boolean flag = false;
        for (Purchase p : purchases) {
            if (purchase.getCost().getKopecks() == p.getCost().getKopecks()) {
                System.out.println(p + " - buy at the same price");
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("purchase not found");
        }
    }
}